package com.ServeSync.backend.Config;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {


            return httpSecurity

                    .csrf(csrf ->csrf.disable())            /* este es el token csrf pero no lo estoy usando aun   */
                    .authorizeHttpRequests(authRequest ->
                            authRequest
                                    .requestMatchers("/auth/**").permitAll()    /* llega todas las rutas de /auth*/
                                    .anyRequest().authenticated()

                    ).formLogin(withDefaults()).build();


    }
}
