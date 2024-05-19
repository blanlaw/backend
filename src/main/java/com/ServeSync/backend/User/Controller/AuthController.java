package com.ServeSync.backend.User.Controller;

import com.ServeSync.backend.User.Auth.AuthResponse;
import com.ServeSync.backend.User.Auth.LoginRequest;
import com.ServeSync.backend.User.Auth.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {



    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest){

        return  ResponseEntity.ok(new AuthResponse());

    }

    @PostMapping(value ="/register")

    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest registerRequest){

        return  ResponseEntity.ok(new AuthResponse());

    }



}
