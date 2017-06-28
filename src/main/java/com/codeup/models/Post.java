package com.codeup.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * Created by frenchfryes on 6/20/17.
 */
@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100)
    @NotBlank(message = "The title of your ad cannot be empty")
    @Size(min = 5, message = "Titles must be at least 3 characters long")
    private String title;

    @Column(nullable = false, columnDefinition = "Text")
    @NotBlank(message = "Please provide a description for your ad")
    private String body;

    @Column(nullable = true)
    private String imageUrl;

    @ManyToOne
    @JsonManagedReference
    private User owner;



    public Post(String title, String body, User user, String imageUrl) {
        this.title = title;
        this.body = body;
        this.owner = user;
        this.imageUrl = imageUrl;
    }

    public Post() {
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public User getUser() {
        return owner;
    }

    public void setUser(User user) {
        this.owner = user;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}

