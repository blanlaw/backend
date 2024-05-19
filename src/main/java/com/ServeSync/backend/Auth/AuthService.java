package com.ServeSync.backend.Auth;

import com.ServeSync.backend.Jwt.JwtAuth;
import com.ServeSync.backend.Jwt.JwtService;
import com.ServeSync.backend.User.Rol;
import com.ServeSync.backend.User.UserEntity;
import com.ServeSync.backend.User.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {


    private final UserRepository userRepository;
    private final JwtAuth jwtAuth;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEconder;


    public AuthResponse login(LoginRequest loginRequest){


        return null;
    }

    public AuthResponse register(RegisterRequest registerRequest){

        UserEntity userEntity = UserEntity.builder()
                .name(registerRequest.getName())
                .lastname(registerRequest.getLastname())
                .years(registerRequest.getYears())
                .email(registerRequest.getEmail())
                .password(passwordEconder.encode(registerRequest.getPassword()))
                .cellphone(registerRequest.getCellphone())
                .rol(Rol.USER)
                .build();

        userRepository.save(userEntity);
        return AuthResponse.builder()
                .token(jwtService.getToken(userEntity))
                .build();
    }
}
