package com.codeup.models;

import javax.persistence.*;

/**
 * Created by frenchfryes on 6/20/17.
 */
@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "Text")
    private String body;
    @OneToOne
    private User owner;

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
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
}

