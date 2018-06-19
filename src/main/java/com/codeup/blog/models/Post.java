package com.codeup.blog.models;

public class Post {
    private String title;
    private String body;
    private long id;

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

    public void setID(long id){
        this.id = id;
    }

    public Long getID(){
        return id;
    }

    public void setTitle() {
        this.title = title;
    }

    public String getTitle(){
        return title;
    }

    public void setBody() {
        this.body = body;
    }

    public String getBody() {
        return body;
    }
}
