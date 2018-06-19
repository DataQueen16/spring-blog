package com.codeup.blog.controllers;

import com.codeup.blog.PostService;
import com.codeup.blog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @RequestMapping(path="/posts", method= RequestMethod.GET)
    public String generatePosts(Model view) {
        List<Post> posts = postService.findAll();
        view.addAttribute("posts", posts);
        return "posts/index";
    }

    @RequestMapping(path="/posts/create", method = RequestMethod.POST)
    @ResponseBody
    public String posts() {
        return "Create posts here";
    }
}
