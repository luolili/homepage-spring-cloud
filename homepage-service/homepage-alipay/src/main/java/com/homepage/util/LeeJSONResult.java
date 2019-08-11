package com.homepage.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

@Data
public class LeeJSONResult {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    //业务状态
    private Integer status;
    //响应消息
    private String msg;
    private Object data;

    //构造方法
    public LeeJSONResult() {
    }

    public LeeJSONResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public LeeJSONResult(Object data) {
        this.status = 200;
        this.msg = "ok";
        this.data = data;
    }

    public boolean isOk() {
        return this.status == 200;
    }

    public static LeeJSONResult build(Integer status, String msg, Object data) {
        return new LeeJSONResult(status, msg, data);
    }

    public static LeeJSONResult ok(Object data) {
        return LeeJSONResult.ok(data);
    }

    public static LeeJSONResult ok() {
        return LeeJSONResult.ok(null);
    }

    public static LeeJSONResult errorMsg(String msg) {
        return new LeeJSONResult(500, msg, null);
    }

    //服务器不具备完成请求的功能。例如，服务器无法识别请求方法时可能会返回此代码
    public static LeeJSONResult errorMap(Object data) {
        return new LeeJSONResult(501, "error", data);
    }

    //这是服务器上的一个错误网关,先清除下缓存或者是在服务器上进行刷新试试
    public static LeeJSONResult errorTokenMsg(String msg) {
        return new LeeJSONResult(502, msg, null);
    }

    public static LeeJSONResult errorException(String msg) {
        return new LeeJSONResult(555, msg, null);
    }

    /**
     * 把json形式的数据转为
     *
     * @param jsoData
     * @param clazz
     * @return
     */
    public static LeeJSONResult formatToPojo(String jsoData, Class<?> clazz) {
        try {
            if (clazz == null) {
                return MAPPER.readValue(jsoData, LeeJSONResult.class);
            }
            JsonNode jsonNode = MAPPER.readTree(jsoData);
            JsonNode data = jsonNode.get("data");

            Object obj = null;
            if (clazz != null) {
                if (data.isObject()) {
                    obj = MAPPER.readValue(data.traverse(), clazz);
                } else if (data.isTextual()) {
                    obj = MAPPER.readValue(data.asText(), clazz);
                }
            }
            return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);

        } catch (Exception e) {
            return null;
        }
        //return null;
    }
}

