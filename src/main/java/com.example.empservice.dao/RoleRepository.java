package com.example.empservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.empservice.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
