package com.example.User.Project.With.AuthN_AuthZ_Crud.Auth.Config;

import com.example.User.Project.With.AuthN_AuthZ_Crud.Auth.Security.AJwtFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
    private final AJwtFilter aJwtFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .csrf(c-> c.disable())
                .sessionManagement(s->s
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth

                        .requestMatchers("/favicon.ico").permitAll()
                        .requestMatchers("/login.html", "/signup.html", "/crud.html").permitAll()
                        .requestMatchers("/api/user/signup", "/api/user/login").permitAll()

                        // USER can only GET
                        .requestMatchers(HttpMethod.GET, "/api/crud/**").hasAnyRole("USER", "ADMIN")

                        // ADMIN can do POST PUT DELETE
                        .requestMatchers(HttpMethod.POST, "/api/crud/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/crud/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/crud/**").hasRole("ADMIN")

                        .anyRequest().authenticated()
                )
                .addFilterBefore(aJwtFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
