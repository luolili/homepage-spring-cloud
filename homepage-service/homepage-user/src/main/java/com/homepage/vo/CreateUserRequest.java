package com.homepage.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang.StringUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequest {

    private String username;

    private String email;

    //字段验证
    public boolean vaidate() {
        return StringUtils.isNotEmpty(this.username) &&
                StringUtils.isNotEmpty(this.email);
    }
}
