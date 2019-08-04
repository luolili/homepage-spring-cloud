package com.im.server;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 保存登陆用户的id/name
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Session {


    private String userId;
    private String username;

}
