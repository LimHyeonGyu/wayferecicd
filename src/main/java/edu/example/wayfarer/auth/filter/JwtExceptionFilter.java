package edu.example.wayfarer.auth.filter;

import edu.example.wayfarer.apiPayload.BaseResponse;
import edu.example.wayfarer.apiPayload.code.status.ErrorStatus;
import edu.example.wayfarer.apiPayload.exception.handler.AuthHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtExceptionFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(
            HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        try {
            filterChain.doFilter(request, response);
        } catch (AuthHandler e) {
            response.setContentType("application/json; charset=UTF-8");
            response.setStatus(e.getErrorReasonHttpStatus().getHttpStatus().value());

            ErrorStatus code = (ErrorStatus) e.getCode();

            BaseResponse<Object> errorResponse =
                    BaseResponse.onFailure(code.getCode(), code.getMessage(), null);

            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(response.getOutputStream(), errorResponse);
        }

    }
}