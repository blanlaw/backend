package com.ServeSync.backend.Repository;

import com.ServeSync.backend.Entity.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<ProjectEntity,Integer> {
}
