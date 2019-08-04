package com.im;

import com.im.server.Session;
import io.netty.channel.Channel;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 封装常量和方法
 */
public class Utils {

    //登陆的code
    public static final Integer LOGIN_SUCCESS = 1000;
    public static final AttributeKey<Boolean> LOGIN_STATUS = AttributeKey.newInstance("LOGIN");
    public static final AttributeKey<Session> SESSION = AttributeKey.newInstance("SESSION");
    private static final Map<String, Channel> userIdChannelMap = new ConcurrentHashMap<>();

    public static void markLogin(Channel channel) {
        channel.attr(LOGIN_STATUS).set(true);
    }

    //判断客户端是否 login
    public static boolean hasLogin(Channel channel) {
        Attribute<Boolean> attr = channel.attr(LOGIN_STATUS);
        return attr.get() != null;

    }

    public static void bindSession(Session session, Channel channel) {
        userIdChannelMap.put(session.getUserId(), channel);
        channel.attr(SESSION).set(session);
    }

    public static void unbindSession(Channel channel) {
        if (getSession(channel) != null) {
            userIdChannelMap.remove(getSession(channel).getUserId());
            channel.attr(SESSION).set(null);
        }
    }

    public static Session getSession(Channel channel) {
        return channel.hasAttr(SESSION) ? channel.attr(SESSION).get() : null;
    }

    public static Channel getChannel(String userId) {
        return userIdChannelMap.get(userId);
    }

}
