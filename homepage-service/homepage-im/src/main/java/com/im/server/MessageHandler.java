package com.im.server;

import com.im.Utils;
import com.im.packet.data.MessageRequestData;
import com.im.packet.data.MessageResponseData;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.concurrent.EventExecutorGroup;

public class MessageHandler extends SimpleChannelInboundHandler<MessageRequestData> {


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageRequestData msg) throws Exception {

        //拿到发送方的session
        Session session = Utils.getSession(ctx.channel());

        if (session == null) {
            return;
        }

        //构建 转发消息
        MessageResponseData messageResponseData = new MessageResponseData(session.getUserId(), session.getUsername(), msg.getMessage());
        //转发
        Channel beCalled = Utils.getChannel(msg.getToUser());
        beCalled.writeAndFlush(messageResponseData);
    }

}
