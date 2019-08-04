package com.im.packet.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseData implements EncodedData {

    private Boolean isSuccessful;
    private Integer code;

    @Override
    public byte getCommand() {
        return Command.LOGIN_RESPONSE;
    }
}
