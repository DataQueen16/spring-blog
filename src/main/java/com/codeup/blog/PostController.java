package com.codeup.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    @GetMapping("/posts/{id}")
    public String postID(@PathVariable long id, Model model) {
        id = 1;
       Post post = new Post("Women in Tech", "We are here. We won't go away. We will only get stronger my friend.");
       model.addAttribute("post", post);
        return "posts/show";
    }

    @RequestMapping(path="/posts", method= RequestMethod.GET)
    public String generatePosts(Model model) {
        List<Post> posts = new ArrayList<>();
        Post blog = new Post("How to kiss a girl", "Be sweet and attentive. Get in real close. Kiss her lips like they are delicious strawberries that you cannot get enough of.");
        Post queer = new Post("Love is ours too", "Creating a fair, equal, and fun society.");
        posts.add(blog);
        posts.add(queer);
        model.addAttribute("posts", posts);
        return "posts/index";
    }

    @RequestMapping(path="/posts/create", method = RequestMethod.POST)
    @ResponseBody
    public String posts() {
        return "Create posts here";
    }
}
