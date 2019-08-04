package com.im.codec;

import com.im.packet.data.EncodeData;
import com.im.packet.data.Packet;
import com.im.serializer.SerializerAlgorithm;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.util.concurrent.EventExecutorGroup;

public class PacketEncoder extends MessageToByteEncoder<EncodeData> {

    @Override
    protected void encode(ChannelHandlerContext ctx, EncodeData msg, ByteBuf out) throws Exception {
        Packet p = new Packet(msg.getCommand(), SerializerAlgorithm.DEFAULT.serialize(msg));
        p.encode(out);
        //看起来好像不需要再writeFlush
    }
}
