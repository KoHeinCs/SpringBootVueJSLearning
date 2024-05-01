package com.ashwetaw.springbootgenericcrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class SpringbootGenericCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootGenericCrudApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfig(){
        return new WebMvcConfigurer() {

            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:8080") // Specify allowed origins
                        .allowedMethods("GET", "POST", "PUT", "DELETE") // Specify allowed methods
                        .allowedHeaders("*") // Specify allowed headers
                        .allowCredentials(true) // Allow credentials such as cookies
                        .maxAge(3600); // Set max age of preflight requests

            }

        };
    }

}
