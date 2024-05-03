package com.ashwetaw.springbootgenericcrud.config.security.filter;

import com.ashwetaw.springbootgenericcrud.common.CommonResponse;
import com.ashwetaw.springbootgenericcrud.config.security.constant.SecurityConstant;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author koheincs
 * @created at 03/05/2024
 **/
@Component
public class JWTAuthenticationEntryPoint extends Http403ForbiddenEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException {
        CommonResponse httpResponse = new CommonResponse(SecurityConstant.FORBIDDEN_MESSAGE,HttpStatus.FORBIDDEN);
        response.setStatus(HttpStatus.FORBIDDEN.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        OutputStream outputStream = response.getOutputStream();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(outputStream,httpResponse);
        outputStream.flush();
    }
}
