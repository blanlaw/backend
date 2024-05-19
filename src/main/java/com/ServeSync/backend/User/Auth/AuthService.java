package com.ServeSync.backend.User.Auth;

import com.ServeSync.backend.Jwt.JwtAuth;
import com.ServeSync.backend.Jwt.JwtService;
import com.ServeSync.backend.User.UserEntity;
import com.ServeSync.backend.User.UserRepository;
import org.springframework.stereotype.Service;

@Service

public class AuthService {


    private final UserRepository userRepository;
    private final JwtAuth jwtAuth;
    private final JwtService jwtService;

    public AuthService(UserRepository userRepository, JwtAuth jwtAuth, JwtService jwtService) {
        this.userRepository = userRepository;
        this.jwtAuth = jwtAuth;
        this.jwtService = jwtService;
    }

    public AuthResponse login(LoginRequest loginRequest){


        return null;
    }

    public AuthResponse register(RegisterRequest registerRequest){

        UserEntity userEntity = UserEntity.builder()
                .name(registerRequest.getName())
                .lastname(registerRequest.getLastname())
                .years(registerRequest.getYears())
                .email(registerRequest.getEmail())
                .cellphone(registerRequest.getCellphone())
                .build();

        userRepository.save(userEntity);
        return AuthResponse.builder()
                .token(jwtService.getToken(userEntity))
                .build();
    }
}
