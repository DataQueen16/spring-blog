package com.codeup.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    @GetMapping("/posts")
    public @ResponseBody String post() {
        return "create a post here";
    }

    @GetMapping("/posts/index/{id}")
    @ResponseBody
    public Post postID(@PathVariable int id) {
        Post blog = new Post("Women in Tech", "We are here. We won't go away. We will only get stronger my friend.");
        return blog;
    }

    @RequestMapping(path="/posts/show", method= RequestMethod.GET)
    @ResponseBody
    public List<Post> generatePosts(@PathVariable List<Post> posts) {
        posts = new ArrayList<>();
        Post blog = new Post("How to kiss a girl", "Be sweet and attentive. Get in real close. Kiss her lips like they are delicious strawberries that you cannot get enough of.");
        Post queer = new Post("Love is ours too", "Creating a fair, equal, and fun society.");
        posts.add(blog);
        posts.add(queer);
        return posts;
    }

    @RequestMapping(path="/posts/create", method = RequestMethod.POST)
    @ResponseBody
    public String posts() {
        return "Create posts here";
    }
}
