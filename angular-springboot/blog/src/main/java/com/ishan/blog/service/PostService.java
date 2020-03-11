package com.ishan.blog.service;

import com.ishan.blog.dto.PostDto;
import com.ishan.blog.model.Post;
import com.ishan.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.function.Supplier;

@Service
public class PostService {
    @Autowired
    private  AuthService authService;

    @Autowired
    private PostRepository postRepository;

    public  void createPost(PostDto postDto) throws Throwable {

        Post post= new Post();
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        User user = (User) authService.getCurrentUser().orElseThrow((Supplier)
                new IllegalArgumentException("NO user Logged in"));
        post.setUsername(user.getUsername());
        post.setCreatedOn(Instant.now());

        postRepository.save(post);

    }

    public List<PostDto> showAllPosts() {
    List<Post> posts= postRepository.findAll();
    return posts.stream().map(this::mapFromPostDto).collect(toList());
    }

    private PostDto mapFromPostDto(Post post){
        PostDto postDto= new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setContent(post.getContent());
        postDto.setUsername(post.getUsername());
        return postDto;

    }
    public Object readSinglePost(Long id) {
    }
}
