package com.im;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.AttributeKey;
import io.netty.util.concurrent.GenericFutureListener;

import java.util.concurrent.Future;

public class NettyServer {

    public static void main(String[] args) throws InterruptedException {
        ServerBootstrap serverBootstrap = new ServerBootstrap();

        NioEventLoopGroup boss = new NioEventLoopGroup(1);
        NioEventLoopGroup worker = new NioEventLoopGroup(2);
        serverBootstrap
                .group(boss, worker)
                .attr(AttributeKey.newInstance("serverName"), "nettyServer")
                .childAttr(AttributeKey.newInstance("clientKey"), "clientValue")
                .channel(NioServerSocketChannel.class)
                .handler(new ChannelInitializer<NioServerSocketChannel>() {
                    protected void initChannel(NioServerSocketChannel ch) throws Exception {
                        /**
                         * childHandler()用于指定处理新连接数据的读写处理逻辑，handler()用于指定在服务端启动过程中的一些逻辑，通常情况下呢，我们用不着这个方法。
                         */
                    }
                })

                .childOption(ChannelOption.SO_KEEPALIVE, true)
                .childOption(ChannelOption.TCP_NODELAY, true)
                .option(ChannelOption.SO_BACKLOG, 1024)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    protected void initChannel(NioSocketChannel ch) {
                        //ch.pipeline().addLast(new StringDecoder());
                        /*ch.pipeline().addLast(new SimpleChannelInboundHandler<String>() { // 4
                            @Override
                            protected void channelRead0(ChannelHandlerContext ctx, String msg) {
                                System.out.println(msg);
                            }
                        });*/

                        ch.pipeline().addLast(new FirstServerHandler());
                    }
                });
        Channel channel = serverBootstrap.bind(8888).sync().channel();
        channel.closeFuture().sync();

        //bind(serverBootstrap, 8080);
    }


   /* private static void bind(final ServerBootstrap serverBootstrap, final int port) {
        serverBootstrap.bind(port).addListener((GenericFutureListener<Future<? super Void>>) future -> {
            if (future.isSuccess()) {
                System.out.println("端口[" + port + "]绑定成功!");
            } else {
                System.err.println("端口[" + port + "]绑定失败!");
                bind(serverBootstrap, port + 1);
            }
        });
    }*/

}

