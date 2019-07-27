package com.homepage.security;

public class CurrentUserHolder {

    private static final ThreadLocal<String> holder =
            new ThreadLocal<>();

    public static String getUser() {
        return (holder.get() != null ? holder.get() : "unknow");
    }

    public static void setUser(String user) {
        holder.set(user);
    }


}
