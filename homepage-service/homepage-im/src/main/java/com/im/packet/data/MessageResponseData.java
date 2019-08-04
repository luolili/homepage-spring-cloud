package com.im.packet.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageResponseData implements EncodeData {

    private String fromUserId;

    private String fromUserName;


    private String MessageResponse;

    @Override
    public byte getCommand() {
        return Command.MESSGAE_RESPONSE;
    }
}
