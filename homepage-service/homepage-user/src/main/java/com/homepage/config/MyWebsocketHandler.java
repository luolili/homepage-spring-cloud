package com.homepage.config;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.websocketx.WebSocketClientHandshaker;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker;

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

        } else if (msg instanceof WebSocketFrame) {//web  socket请求
            //-2 建立连接
        }

    }

    private void handleHttpRequest(ChannelHandlerContext ctx, FullHttpRequest req) {
        if (!req.getDecoderResult().isSuccess() || !("".equals(req.headers().get("Upgrade")))) {

        }
    }
}
