package com.ashwetaw.springbootgenericcrud.config.security;

import com.ashwetaw.springbootgenericcrud.config.security.constant.SecurityConstant;
import com.ashwetaw.springbootgenericcrud.config.security.filter.JWTAuthenticationEntryPoint;
import com.ashwetaw.springbootgenericcrud.config.security.filter.JWTAuthorizationFilter;
import com.ashwetaw.springbootgenericcrud.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author koheincs
 * @created at 02/05/2024
 **/
@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final UserService userService;
    private final JWTAuthorizationFilter jwtAuthorizationFilter;
    private final JWTAuthenticationEntryPoint jwtAuthenticationEntryPoint;

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

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }


    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

            httpSecurity.authenticationProvider(authenticationProvider());

            httpSecurity.cors(AbstractHttpConfigurer::disable);

            httpSecurity.csrf(AbstractHttpConfigurer::disable);

            httpSecurity.authorizeHttpRequests(authorizationManagerRequestMatcherRegistry ->
                    authorizationManagerRequestMatcherRegistry
                            .requestMatchers(SecurityConstant.PUBLIC_URLS)
                            .permitAll()
                            .anyRequest()
                            .authenticated()
            );

            httpSecurity.sessionManagement(sess->sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

            httpSecurity.addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class);


            // handle other unexpected security exceptions
            httpSecurity.exceptionHandling(exc -> exc.authenticationEntryPoint(jwtAuthenticationEntryPoint));



            return httpSecurity.build();


    }




}
