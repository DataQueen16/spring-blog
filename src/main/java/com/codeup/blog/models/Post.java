package com.codeup.blog.models;

import javax.persistence.*;

@Entity
@Table(name="posts")
public class Post {
    @Id @GeneratedValue
    private long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String body;

    @ManyToOne
    @JoinColumn
    private User user;


    public Post(){}

    public Post(String title, String body){
        this.title = title;
        this.body = body;
    }

    public Post(long id, String title, String body){
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public Post(long id, User user, String title, String body) {
        this.id = id;
        this.user = user;
        this.title = title;
        this.body = body;
    }

    public void setUser(User user){ this.user = user; }

    public User getUser() { return user; }

    public void setId(long id){
        this.id = id;
    }

    public Long getId(){
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle(){
        return title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getBody() {
        return body;
    }
}
