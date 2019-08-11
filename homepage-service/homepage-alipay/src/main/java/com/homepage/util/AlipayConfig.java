package com.homepage.util;

import org.springframework.context.annotation.Configuration;

@Configuration
public class AlipayConfig {
    public static final String app_id = "";
    public static final String mechat_private_key = "";
    public static final String alipay_public_key = "";
    public static final String notify_url = "http://localhost:8080/alipay/alipayNotifyNotice.action";
    public static final String return_url = "http://localhost:8080/alipay/alipayReturnNotice.action";
    public static String sign_type = "RSA2";

    public static String charset = "utf-8";
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
}
