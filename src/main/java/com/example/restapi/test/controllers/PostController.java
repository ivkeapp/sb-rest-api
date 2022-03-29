package com.example.restapi.test.controllers;

import com.example.restapi.test.entities.Post;
import com.example.restapi.test.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    private PostService service;

    @PostMapping("/addpost")
    public Post addPost(@RequestBody Post post){
        return service.savePost(post);
    }

    @PostMapping("/addposts")
    public List<Post> addPosts(@RequestBody List<Post> posts){
        return service.savePosts(posts);
    }

    @GetMapping("/posts")
    public List<Post> getAllPosts(){
        return service.getPosts();
    }

    @GetMapping("/post/{id}")
    public Post getPostById(@PathVariable int id){
        return service.getPostById(id);
    }

    @PutMapping ("/update")
    public Post updatePost(@RequestBody Post post){
        return service.updatePost(post);
    }

    @DeleteMapping ("/delete/{id}")
    public String deletePost(@PathVariable int id){
        return service.deletePost(id);
    }

    @GetMapping("/postProc")
    public List getPosts(){
        return service.getAllPosts();
    }
}
