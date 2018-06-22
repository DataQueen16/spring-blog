package com.codeup.blog.controllers;

import com.codeup.blog.relationships.PostService;
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
        view.addAttribute("post", postService.findOne(id));
        return "posts/edit";
    }


    @GetMapping("/posts")
    public String generatePosts(Model view, @RequestParam(name = "search", required = false) String searchTerm) {
        // if there's a search term, show results for that search
        // else, just show all the posts
        List<Post> posts;
        if (searchTerm == null) {
            posts = postService.findAll();
        } else {
            posts = postService.search(searchTerm);
        }

        view.addAttribute("posts", posts);
        view.addAttribute("searchTerm", searchTerm);

        // relative path for the .html file inside of resources/templates w/o the .html
        return "posts/index";
    }

    @GetMapping("/posts/create")
    public String create(Model view
    ){
        view.addAttribute("post", new Post());
        return "/posts/create";
    }

    @PostMapping("/posts/create")
    public String savePost(@ModelAttribute Post post) {
        postService.save(post);

        return "redirect:/posts";
    }


    @PostMapping("/posts/{id}/edit")
    public String updatePost(@PathVariable long id, @ModelAttribute Post post) {
        postService.save(post);
        return "redirect:/posts/" + id;
    }

    @PostMapping("/posts/create")
    public String posts(
            @ModelAttribute Post post
    ) {
        postService.save(post);
        return "redirect:/posts";
    }

    @PostMapping("/posts/{id}/delete")
    public String delete(@PathVariable long id) {
        postService.delete(id);
        return "redirect:/posts";
    }
}
