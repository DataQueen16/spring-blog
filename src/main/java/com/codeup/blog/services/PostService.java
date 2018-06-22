package com.codeup.blog.services;

import com.codeup.blog.models.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    private PostRepository postRepository;

    public PostService(PostRepository postRepository){
        this.postRepository = postRepository;
    }



//    public PostService() {
//        createPosts();
//    }


    public Iterable<Post> findAll() {
        return postRepository.findAll();
    }

    public Post save(Post post) {
        postRepository.save(post);
        return post;
    }

    public Post findOne(long id) {
        Post post = postRepository.findOne(id);
        return post;
    }
}
