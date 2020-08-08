package com.cloudDB.auth2server.repository;

import com.cloudDB.auth2server.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDetailRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUserName(String name);

}
