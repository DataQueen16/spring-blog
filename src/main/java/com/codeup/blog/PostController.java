package com.codeup.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    @GetMapping("/posts")
    public @ResponseBody String post() {
        return "Posts index page";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String postID(@PathVariable int id) {
        return "View an individual post at " + id;
    }

    @RequestMapping(path="/posts/create", method= RequestMethod.GET)
    @ResponseBody
    public String generatePosts() {
        return "View the post form";
    }

    @RequestMapping(path="/posts/create", method = RequestMethod.POST)
    @ResponseBody
    public String posts() {
        return "Create posts here";
    }
}
