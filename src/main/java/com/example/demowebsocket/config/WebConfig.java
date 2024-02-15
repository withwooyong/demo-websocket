package com.example.demowebsocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/test/**")
//                .addResourceLocations("classpath:/static-loc/");
//    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 모든 경로에 대해 CORS 설정
                .allowedOrigins(
                        "http://localhost:8080",
                        "http://localhost:3000",
                        "http://127.0.0.1:8080",
                        "http://127.0.0.1:3000") // 허용할 오리진 지정
                .allowedMethods("GET", "POST", "PUT", "DELETE") // 허용할 HTTP 메소드
                .allowedHeaders("*") // 허용할 헤더
                .allowCredentials(true) // 쿠키를 포함할지 여부
                .maxAge(3600); // pre-flight 요청의 캐시 지속 시간(초 단위)
    }
}