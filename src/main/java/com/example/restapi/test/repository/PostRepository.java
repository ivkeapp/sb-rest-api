package com.example.restapi.test.repository;

import com.example.restapi.test.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

public interface PostRepository extends JpaRepository<Post, Integer> {
    @Procedure("getPost")
    int getAllPostsProcedure(String model);
}
