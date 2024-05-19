package com.ServeSync.backend.User;

import com.ServeSync.backend.Subs.RegistersEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity(name = "user")
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor

public class UserEntity implements UserDetails {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   @Column(name = "name_user", nullable = false)
   private String name;
   @Column(name = "lastname_")
   private String lastname;
   @Column(name = "year_user")
   private int years;
   @Column(name = "email", unique = true)
   private String email;
   @Column(name = "password")
   private String password;
   @Column(name = "cellphone")
   private int cellphone;
   @OneToMany(mappedBy = "iduser", cascade = CascadeType.ALL, orphanRemoval = true)
   private Set<RegistersEntity> registersEntities = new HashSet<>();
   @Enumerated(EnumType.STRING)
   private Rol rol;


   @Override
   public Collection<? extends GrantedAuthority> getAuthorities() {
      return List.of(new SimpleGrantedAuthority((rol.name())));
   }

   @Override
   public String getPassword() {
      return "";
   }

   @Override
   public String getUsername() {
      return "";
   }


   @Override
   public boolean isAccountNonExpired() {
      return true;
   }

   @Override
   public boolean isAccountNonLocked() {
      return true;
   }

   @Override
   public boolean isCredentialsNonExpired() {
      return true;
   }

   @Override
   public boolean isEnabled() {
      return true;
   }
}
