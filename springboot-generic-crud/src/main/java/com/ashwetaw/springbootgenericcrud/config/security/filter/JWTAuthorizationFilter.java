package com.ashwetaw.springbootgenericcrud.config.security.filter;

import com.ashwetaw.springbootgenericcrud.config.security.constant.SecurityConstant;
import com.ashwetaw.springbootgenericcrud.config.security.util.JWTTokenProvider;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * @author koheincs
 * @created at 03/05/2024
 **/
@Component
@RequiredArgsConstructor
public class JWTAuthorizationFilter extends OncePerRequestFilter {
    private final JWTTokenProvider jwtTokenProvider;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String authorizationHeader = request.getHeader("Authorization");

        if (authorizationHeader == null || !authorizationHeader.startsWith(SecurityConstant.TOKEN_PREFIX)){
            filterChain.doFilter(request,response);
            return;
        }

        String token = authorizationHeader.substring(SecurityConstant.TOKEN_PREFIX.length());

        if (jwtTokenProvider.validateToken(token) && SecurityContextHolder.getContext().getAuthentication() == null){

            String username = jwtTokenProvider.getUsername(token);

            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                    new UsernamePasswordAuthenticationToken(username,null,null);
            usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

        }else {
            SecurityContextHolder.clearContext();
        }

        filterChain.doFilter(request,response);

    }
}
