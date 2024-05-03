package com.ashwetaw.springbootgenericcrud.config.security.constant;

/**
 * @author koheincs
 * @created at 02/05/2024
 **/
public class SecurityConstant {
    public static final String[] PUBLIC_URLS = {"/swagger-ui/**","/v3/api-docs/**","/api/auth/**"};
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String FORBIDDEN_MESSAGE = "You need to log in to access this page";

}
