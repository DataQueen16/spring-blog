package com.codeup.blog.controllers;

import com.codeup.blog.models.User;
import com.codeup.blog.repositories.UserRepository;
import com.codeup.blog.services.PostService;
import com.codeup.blog.models.Post;
import com.codeup.blog.services.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostController {

    private PostService postService;
    private UserRepository userRepository;
    private UserService userService;

    public PostController(PostService postService, UserRepository userRepository, UserService userService)
    {
        this.postService = postService;
        this.userRepository = userRepository;
        this.userService = userService;
    }


    @GetMapping("/posts")
    public String generatePosts(Model view, @RequestParam(name = "search", required = false) String searchTerm) {

        List<Post> posts;
        if (searchTerm == null) {
            posts = postService.findAll();
        } else {
            posts = postService.search(searchTerm);
        }

        view.addAttribute("posts", posts);
        view.addAttribute("searchTerm", searchTerm);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String postID(@PathVariable long id, Model view) {
       Post post = postService.findOne(id);
       view.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("/posts/{id}/edit")
    public String edit(@PathVariable long id, Model view) {

        view.addAttribute("post", postService.findOne(id));
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String updatePost(@PathVariable long id, @ModelAttribute Post post) {
        if(userService.canEdit(post)){
        postService.save(post);
        }
        return "redirect:/posts/" + id;
    }

    @PostMapping("/posts/{id}/delete")
    public String delete(@PathVariable long id, @ModelAttribute Post post) {
        if(userService.canEdit(post)) {
        postService.delete(id);
        }
        return "redirect:/posts";
    }

    @GetMapping("/posts/create")
    public String create(Model view){
        view.addAttribute("post", new Post());
        return "/posts/create";
    }

    @PostMapping("/posts/create")
    public String savePosts(
            @ModelAttribute Post post
    ) {
        postService.save(post);
        System.out.println("This is the message");
        return "redirect:/posts";
    }

}
