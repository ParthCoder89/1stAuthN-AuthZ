package com.example.User.Project.With.AuthN_AuthZ_Crud.Auth.Security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
@RequiredArgsConstructor
public class AJwtFilter extends OncePerRequestFilter {

    private final AJwtUtil aJwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String authHeader = request.getHeader("Authorization");
        String jwtToken = null;
        String userName = null;

        if(authHeader != null && authHeader.startsWith("Bearer ")){
            jwtToken = authHeader.substring(7);
            userName = aJwtUtil.extractUsername(jwtToken);
        }

        if(userName != null && SecurityContextHolder.getContext().getAuthentication() == null){
            if(aJwtUtil.validateToken(jwtToken)){

                String role = aJwtUtil.extractRole(jwtToken);

                UsernamePasswordAuthenticationToken authToken = new
                        UsernamePasswordAuthenticationToken(userName, null, List
                            .of(new SimpleGrantedAuthority(role)));
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);

                System.out.println("Auth Header: " + authHeader);
                System.out.println("Token: " + jwtToken);
                System.out.println("Username: " + userName);
                System.out.println("Role: " + role);
            }
        }
        filterChain.doFilter(request, response);



    }
}
