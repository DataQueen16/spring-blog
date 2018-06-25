package com.codeup.blog.services;

import com.codeup.blog.models.Post;
import com.codeup.blog.models.User;
import com.codeup.blog.repositories.PostRepository;
import com.codeup.blog.repositories.Users;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;
    private final Users users;


    public PostService(PostRepository postRepository, Users users) {
        this.postRepository = postRepository;
        this.users = users;
    }


    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public Post save(Post post) {
        User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = users.findById(sessionUser.getId());
        post.setUser(user);
        postRepository.save(post);
        return post;
    }

    public Post findOne(long id) {
        return postRepository.findOne(id);
    }

    public List<Post> searchByTitle(String title) {
        return postRepository.findByTitle(title);
    }

    public void delete(long id){
    postRepository.delete(id);
    }

    public List<Post> search(String searchTerm){
        return postRepository.findByTitleLike("%" + searchTerm + "%");
    }

}
