package com.homepage.config;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.handler.codec.http.websocketx.*;
import io.netty.util.CharsetUtil;

import java.util.Date;

public class MyWebsocketHandler extends SimpleChannelInboundHandler<Object> {

    private WebSocketServerHandshaker handshaker;
    private static final String WEB_SOCKET_URL = "ws://localhost:8888/websocket";
    //客户端与服务端创建连接的时候调用
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        //super.channelActive(ctx);
        NettyConfig.group.add(ctx.channel());
        System.out.println("client and server start to connect--");
    }

    //客户端与服务端断开连接的时候调用
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        //super.channelInactive(ctx);
        NettyConfig.group.remove(ctx.channel());
        System.out.println("client and server start to disconnect--");
    }

    //服务端接受客户端发过来的数据结束之后调用
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        //super.channelReadComplete(ctx);
        ctx.flush();
    }

    //出现ex时调用
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //super.exceptionCaught(ctx, cause);
        cause.printStackTrace();
        ctx.close();
    }

    //5.0.x的netty才有这个方法：处理来自客户端websocket请求的核心方法
    @Override
    protected void messageReceived(ChannelHandlerContext ctx, Object msg) throws Exception {
        //-1 客户端发起请求
        //http握手请求
        if (msg instanceof FullHttpRequest) {
            handleHttpRequest(ctx, (FullHttpRequest) msg);
        } else if (msg instanceof WebSocketFrame) {//web  socket请求
            //-2 建立连接
            handleWsFrame(ctx, (WebSocketFrame) msg);
        }

    }

    private void handleWsFrame(ChannelHandlerContext ctx, WebSocketFrame frame) {
        if (frame instanceof CloseWebSocketFrame) {
            handshaker.close(ctx.channel(), (CloseWebSocketFrame) frame.retain());
        }
        //是否是ping消息
        if (frame instanceof PingWebSocketFrame) {
            ctx.channel().write(new PongWebSocketFrame(frame.content().retain()));
        }

        //2机制消息
        if (!(frame instanceof TextWebSocketFrame)) {
            System.out.println("not support 2 msg");
            throw new RuntimeException(this.getClass().getName() + "not support");
        }

        //获取客户端发送那个的消息
        String text = ((TextWebSocketFrame) frame).text();
        System.out.println("server receives  the msg" + text);
        TextWebSocketFrame tws = new TextWebSocketFrame(new Date().toString() +
                ctx.channel().id() + "----->" + text);

        //server 群发
        NettyConfig.group.writeAndFlush(tws);


    }
    //处理http握手请求
    private void handleHttpRequest(ChannelHandlerContext ctx, FullHttpRequest req) {
        if (!req.getDecoderResult().isSuccess() || !("".equals(req.headers().get("Upgrade")))) {
            sendHttpResponse(ctx, req,
                    new DefaultFullHttpResponse(HttpVersion.HTTP_1_0, HttpResponseStatus.BAD_REQUEST));
            return;
        }

        WebSocketServerHandshakerFactory wsFactory =
                new WebSocketServerHandshakerFactory(WEB_SOCKET_URL, null, false);
        handshaker = wsFactory.newHandshaker(req);
        if (handshaker == null) {
            WebSocketServerHandshakerFactory.sendUnsupportedWebSocketVersionResponse(ctx.channel());
        } else {
            handshaker.handshake(ctx.channel(), req);
        }
    }

    //服务端向客户端响应消息
    private void sendHttpResponse(ChannelHandlerContext ctx, FullHttpRequest req,
                                  DefaultFullHttpResponse resp) {

        if (resp.getStatus().code() != 200) {
            ByteBuf byteBuf = Unpooled.copiedBuffer(resp.getStatus().toString(), CharsetUtil.UTF_8);
            resp.content().writeBytes(byteBuf);
            byteBuf.release();
        }
        //server 向client发送数据
        ChannelFuture f = ctx.channel().writeAndFlush(resp);
        if (resp.getStatus().code() != 200) {
            f.addListener(ChannelFutureListener.CLOSE);
        }

    }
}
