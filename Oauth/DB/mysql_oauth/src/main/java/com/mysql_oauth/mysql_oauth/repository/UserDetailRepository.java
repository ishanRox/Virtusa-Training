package com.mysql_oauth.mysql_oauth.repository;

import com.mysql_oauth.mysql_oauth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDetailRepository extends JpaRepository<User,Integer> {


    Optional<User> findByUsername(String name);

}
