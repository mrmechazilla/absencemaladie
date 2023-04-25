package com.example.FirstProject.security;

public interface SecurityParams {
    public static final String HEADER_STRING = "Authorization";
    public static final String SECRET = "youssef";
    public static final long EXPIRATION_TIME = 10L*24*3600*3600*100; // 10 days
    public static final String TOKEN_PREFIX = "Bearer ";
}
