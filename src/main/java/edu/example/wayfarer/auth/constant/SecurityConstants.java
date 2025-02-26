package edu.example.wayfarer.auth.constant;

import java.util.Arrays;
import java.util.stream.Stream;

public class SecurityConstants {

    public static final String[] swaggerUrls = {"/swagger-ui/**", "/swagger-resources/**", "/v3/api-docs/**"};
    public static final String[] allowUrls = {
            "/api/v1/posts/**",
            "/api/v1/replies/**",
            "/login",
            "/auth/kakao/callback/**",
            "/auth/login/google", // 구글 경로 추가
            "/login/oauth2/code/google", // OAuth 리다이렉트 경로 추가
            "/logout",
            "/refresh",
            "/favicon.ico",
            "/", // 메인페이지
            "/auth/logout"
     };

    // 허용 Urls
    public static String[] allowedUrls = Stream.concat(Arrays.stream(swaggerUrls), Arrays.stream(allowUrls))
            .toArray(String[]::new);

}
