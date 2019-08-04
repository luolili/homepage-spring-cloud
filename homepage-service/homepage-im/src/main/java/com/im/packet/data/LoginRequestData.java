package com.im.packet.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cache.annotation.EnableCaching;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequestData implements EncodedData {

    private String userId;

    private String username;

    private String password;

    @Override
    public byte getCommand() {
        return Command.LOGIN_REQUEST;
    }
}
