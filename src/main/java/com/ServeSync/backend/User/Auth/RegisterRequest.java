package com.ServeSync.backend.User.Auth;

import com.ServeSync.backend.Subs.RegistersEntity;
import com.ServeSync.backend.User.Rol;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {


    private int id;

    private String name;

    private String lastname;

    private int years;

    private String email;

    private int cellphone;

}
