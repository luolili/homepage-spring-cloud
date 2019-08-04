package com.im.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.AttributeKey;

/**
 * netty server
 */
public class Server {

    public static void main(String[] args) {
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        NioEventLoopGroup boss = new NioEventLoopGroup(1);
        NioEventLoopGroup worker = new NioEventLoopGroup(2);
        serverBootstrap.group(boss, worker)
                .attr(AttributeKey.newInstance("serverName"), "nettyServer")
                .childAttr(AttributeKey.newInstance("clientKey"), "clientValue")
                .channel(NioServerSocketChannel.class)
                .handler(new ChannelInitializer<NioServerSocketChannel>() {

                    @Override
                    protected void initChannel(NioServerSocketChannel ch) throws Exception {

                    }
                })
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                .childOption(ChannelOption.TCP_NODELAY, true)
                .option(ChannelOption.SO_BACKLOG, 1024)
                .childHandler(new ChannelInitializer<NioServerSocketChannel>() {
                    @Override
                    protected void initChannel(NioServerSocketChannel ch) throws Exception {
                        ch.pipeline()
                                .addLast(new LifeCycleTestHandler());
                        //检验模数 和拆包
                        ch.pipeline().addLast(new Spliter());

                        //解码
                        ch.pipeline().addLast(new PacketDecoder());
                        //登录
                        ch.pipeline().addLast(new LoginHandler());
                        //检验登录
                        ch.pipeline().addLast(new AuthHandler());
                        ch.pipeline().addLast(new MessageHandler());

                        ch.pipeline().addLast(new PacketEncoder());
                    }
                });


    }
}
