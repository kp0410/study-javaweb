package com.kunpeng.util;

import javax.servlet.http.Cookie;

public class CookieUtils {

    /**
     *
     * @param name
     * @param cookies
     * @return
     */
    public static Cookie findCookie(String name, Cookie[] cookies) {
        if (name == null || cookies == null || cookies.length == 0) return null;
        for (Cookie cookie : cookies) {
            if (name.equals(cookie.getName())) return cookie;
        }
        return null;
    }
}