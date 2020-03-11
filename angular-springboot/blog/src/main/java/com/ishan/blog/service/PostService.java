package com.ishan.blog.service;

import com.ishan.blog.dto.PostDto;
import com.ishan.blog.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;

import java.time.Instant;
import java.util.function.Supplier;

public class PostService {
    @Autowired
    private  AuthService authService;

    public  void createPost(PostDto postDto) throws Throwable {

        Post post= new Post();
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        User user = (User) authService.getCurrentUser().orElseThrow((Supplier)
                new IllegalArgumentException("NO user Logged in"));
        post.setUsername(user.getUsername());
        post.setCreatedOn(Instant.now());

    }
}
