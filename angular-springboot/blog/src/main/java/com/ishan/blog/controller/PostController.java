package com.ishan.blog.controller;

import com.ishan.blog.dto.PostDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts/")
public class PostController {

    @PostMapping
    public void createPost(@RequestBody PostDto postDto){

    }

}
