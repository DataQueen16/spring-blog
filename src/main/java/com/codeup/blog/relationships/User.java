package com.codeup.blog.relationships;

import com.codeup.blog.models.Post;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="users")
public class User {
    @Id @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    private List<Post> posts;
}
