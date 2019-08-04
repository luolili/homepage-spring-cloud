package com.im.client;

import com.im.packet.data.LoginResponseData;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class LoginHandler extends SimpleChannelInboundHandler<LoginResponseData> {


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginResponseData msg) throws Exception {

    }
}
