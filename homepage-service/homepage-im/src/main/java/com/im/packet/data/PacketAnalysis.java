package com.im.packet.data;

import io.netty.buffer.ByteBuf;

public interface PacketAnalysis<T> {

    ByteBuf encode(ByteBuf byteBuf);

    /**
     * 当出现更多类型协议的时候 ，这里就
     *
     * @param buf
     * @return
     */
    T decode(ByteBuf buf);

    byte getCommandOperation();

    byte getSerializerAlgorithm();

}
