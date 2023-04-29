package tn.biat.biat.security;


public class SecurityConstants {
    public static final String SECRET = "SECRET_KEY";
    public static final long EXPIRATION_TIME = 3600000;//1800000; // 30 mins
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/users/signup";
    public static final String LOGIN_URL = "/auth/login";
    public static final String LOGOUT_URL = "/auth/logout";
}