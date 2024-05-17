package com.ServeSync.backend.Repository;

import com.ServeSync.backend.Entity.RegistersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterRepository extends JpaRepository<RegistersEntity, Integer> {
}
