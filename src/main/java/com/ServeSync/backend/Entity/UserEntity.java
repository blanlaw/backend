package com.ServeSync.backend.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class UserEntity {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   @Column(name = "name_user")
   private String name;
   @Column(name = "lastname_")
   private String lastname;
   @Column(name = "year_user")
   private int years;
   @OneToMany(mappedBy = "iduser")
   private Set<RegistersEntity> registersEntities;


}
