package com.hospital.sistemahospitalar;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/h2-console/**").permitAll()
                .anyRequest().authenticated()
            )
            .formLogin()
            .and()
            .headers().frameOptions().disable() // necessário para exibir o H2 Console
            .and()
            .csrf().disable(); // necessário para permitir o uso do console H2
        return http.build();
    }
}