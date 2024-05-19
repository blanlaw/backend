package com.ServeSync.backend.Auth.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {


    private int id;

    private String name;

    private String lastname;

    private int years;

    private String email;
    private String password;

    private int cellphone;
}
