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
@Table(name = "project")
public class ProjectEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int idproj;
        @Column(name = "name_proj")
        private String name;
        @Column(name = "description")
        private String description;

        @OneToMany(mappedBy = "idproj", cascade = CascadeType.ALL, orphanRemoval = true)
        private Set<RegistersEntity> RegistersEntity ;




}
