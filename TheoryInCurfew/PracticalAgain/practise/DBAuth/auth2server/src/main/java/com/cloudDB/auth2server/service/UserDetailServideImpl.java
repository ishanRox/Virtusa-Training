package com.cloudDB.auth2server.service;

import com.cloudDB.auth2server.model.AuthUserDetail;
import com.cloudDB.auth2server.model.User;
import com.cloudDB.auth2server.repository.UserDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class UserDetailServideImpl implements UserDetailsService {

    @Autowired
    UserDetailRepository userDetailRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        Optional<User> optionalUser = userDetailRepository.findByUserName(s);
        optionalUser.orElseThrow(() -> new UsernameNotFoundException("username or password wronge"));
        UserDetails userDetails= new AuthUserDetail(optionalUser.get());
        new AccountStatusUserDetailsChecker().check(userDetails);
        return userDetails;
    }
}
