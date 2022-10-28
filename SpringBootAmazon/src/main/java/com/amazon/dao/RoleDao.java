package com.amazon.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amazon.models.Role;

@Repository
public interface RoleDao extends JpaRepository<Role, Integer>{

}
