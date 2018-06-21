package com.codeup.blog.controllers;

import com.codeup.blog.services.PostService;
import com.codeup.blog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts/{id}")
    public String postID(@PathVariable long id, Model view) {
       Post post = postService.findOne(id);
       view.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("/posts/{id}/edit")
    public String edit(@PathVariable long id, Model view) {
        Post existingPost = postService.findOne(id);

        view.addAttribute("post", existingPost);

        return "posts/edit";
    }


    @RequestMapping(path="/posts", method= RequestMethod.GET)
    public String generatePosts(Model view) {
        List<Post> posts = postService.findAll();
        view.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping("/posts/create")
    public String create(Model view
    ){
        view.addAttribute("post", new Post());
        return "/posts/create";
    }


    @PostMapping("/posts/create")
    public String posts(
            @ModelAttribute Post post
    ) {
        postService.save(post);
        return "redirect:/posts";
    }
}
