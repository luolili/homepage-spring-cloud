package com.im.packet.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageRequestData implements EncodedData {

    private String toUser;

    private String message;

    @Override
    public byte getCommand() {
        return Command.MESSAGE_REQUEST;
    }
}
