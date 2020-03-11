package com.ishan.blog.controller;

import com.ishan.blog.dto.PostDto;
import com.ishan.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;

@RestController
@RequestMapping("/api/posts/")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping
    public ResponseEntity <PostDto> createPost(@RequestBody PostDto postDto) throws Throwable {

        postService.createPost(postDto);
      return  new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity <List<PostDto>> showAllPosts(){
        return new ResponseEntity(postService.showAllPosts(),HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<PostDto> getSinglePost(@PathVariable @RequestBody Long id){

        return new ResponseEntity(postService.readSinglePost(id),HttpStatus.OK);
    }
}
