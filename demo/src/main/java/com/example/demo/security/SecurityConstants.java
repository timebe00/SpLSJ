package com.example.demo.security;

public class SecurityConstants {
    public static final String AUTH_LOGIN_URL = "/api/authenticate";
    //  http://www.allkeysqenrator.com
    public static final String JWT_SECRET = "";

    //  JWT 기본 토큰
    public static final String TOKEN_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "JwTtEsT";
    public static final String TOKEN_TYPE = "JWT";
    public static final String TOKEN_ISSUER = "secure-api";
    public static final String TOKEN_AUDIENCE = "secure-app";
}
