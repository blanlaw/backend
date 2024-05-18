package com.ServeSync.backend.Subs;

import com.ServeSync.backend.Product.ProjectEntity;
import com.ServeSync.backend.User.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "register")
public class RegistersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idreg;
    @Column(name = "date_reg")
    private LocalDate datereg;
    @ManyToOne
    @JoinColumn(name = "iduser")
    private UserEntity iduser;
    @ManyToOne
    @JoinColumn(name = "idproj")
    private ProjectEntity idproj;



}
