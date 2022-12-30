package com.vithal.code.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vithal.code.entity.User;

public interface UserRepo extends JpaRepository<User,String> {

}
