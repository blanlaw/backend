package com.ServeSync.backend.Config;

import com.ServeSync.backend.User.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.security.AuthProvider;

@Component
@RequiredArgsConstructor
public class AppConfig {


    private final UserRepository userRepository;
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception{


        return authConfig.getAuthenticationManager();
    }

    /*devuelve el prov*/
    @Bean
    public AuthenticationProvider authenticationProvider(){

        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEconder());


        return authenticationProvider;

    }
    @Bean
    public PasswordEncoder passwordEconder() {

        return new BCryptPasswordEncoder();

    }
    @Bean
    public UserDetailsService userDetailsService() {
        return username -> userRepository.findByName(username)
                .orElseThrow(()-> new UsernameNotFoundException("user no encontrado"));
    }

}
