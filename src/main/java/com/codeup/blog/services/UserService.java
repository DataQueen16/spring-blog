package com.codeup.blog.services;

import com.codeup.blog.models.Post;
import com.codeup.blog.models.User;
import com.codeup.blog.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class UserService {
    private final PostService postService;
    private final UserRepository userRepository;

    public UserService(PostService postService, UserRepository userRepository) {
        this.postService = postService;
        this.userRepository = userRepository;
    }

    public void authenticateUser(Model view, long id) {
        User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.findById(sessionUser.getId());
        Post post = postService.findOne(id);
        if (post.getUser().getId() == user.getId()){
            view.addAttribute("post", post);
    }
}
