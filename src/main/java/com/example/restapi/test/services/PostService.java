package com.example.restapi.test.services;

import com.example.restapi.test.entities.Post;
import com.example.restapi.test.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository repository;

    @Autowired
    @PersistenceContext
    private EntityManager em;
    public List getAllPosts(){
        return em.createNamedStoredProcedureQuery("getPost").getResultList();
    }

    public Post savePost(Post post){
        return repository.save(post);
    }

    public List<Post> savePosts(List<Post>  posts){
        return repository.saveAll(posts);
    }

    public List<Post> getPosts(){
        return repository.findAll();
    }

    public Post getPostById(int id){
        return repository.findById(id).orElse(null);
    }

    public String deletePost(int id){
        repository.deleteById(id);
        return "Post successfully deleted || "+id;
    }

    public Post updatePost(Post post){
        Post existingPost = repository.findById(post.getPost_id()).orElse(null);
        existingPost.setHeadtitle(post.getHeadtitle());
        existingPost.setBody(post.getBody());
        existingPost.setCategory(post.getCategory());
        existingPost.setCreator_id(post.getCreator_id());
        existingPost.setImage_path(post.getImage_path());

        return repository.save(existingPost);
    }

}
