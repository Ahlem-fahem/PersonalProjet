package com.example.worldtour.repository;

import com.example.worldtour.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoleRepository extends JpaRepository<Role, Long> {
    @Query(value = "SELECT r FROM Role r WHERE r.name = :name")
    Role findByName(@Param("name") String name);
}