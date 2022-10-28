package com.amazon.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amazon.models.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer>{

}
