package com.ServeSync.backend.User.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {



    @PostMapping("/login")
    public String login(){

        return "login iniciado";

    }

    @PostMapping(value ="/register")

    public String register(){

        return "registro aceptado";

    }



}
