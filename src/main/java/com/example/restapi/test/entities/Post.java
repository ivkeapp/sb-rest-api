package com.example.restapi.test.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "post")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "getPost",procedureName = "getPost"),
})
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id", updatable = false, nullable = false)
    private int post_id;

    @Column(name = "category", nullable = false)
    private int category_name;

    @Column(name = "creator_id", nullable = false)
    private int creator_name;

    @Column(name = "headtitle", nullable = false, length = 250)
    private String headtitle;

    @Column(name = "body", nullable = false, length = 2500)
    private String body;

    @Column(name = "image_path", length = 250)
    private String image_path;

    @CreationTimestamp
    @Column(name = "date_added", updatable = false, nullable = false)
    private LocalDateTime date_added;

    public int getPost_id() {
        return post_id;
    }

    public int getCategory() {
        return category_name;
    }

    public int getCreator_id() {
        return creator_name;
    }

    public String getHeadtitle() {
        return headtitle;
    }

    public String getBody() {
        return body;
    }

    public String getImage_path() {
        return image_path;
    }

    public LocalDateTime getDate_added() {
        return date_added;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public void setCategory(int category) {
        this.category_name = category;
    }

    public void setCreator_id(int creator_name) {
        this.creator_name = creator_name;
    }

    public void setHeadtitle(String headtitle) {
        this.headtitle = headtitle;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }

    public void setDate_added(LocalDateTime date_added) {
        this.date_added = date_added;
    }
}
