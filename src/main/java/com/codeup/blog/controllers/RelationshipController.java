package com.codeup.blog.controllers;

import com.codeup.blog.models.Post;
import com.codeup.blog.models.User;
import com.codeup.blog.repositories.PostRepository;
import com.codeup.blog.repositories.Users;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@ResponseBody
@Controller
public class RelationshipController {

    private final PostRepository postRepository;
    private final Users users;

    public RelationshipController(PostRepository postRepository, Users users){
        this.postRepository = postRepository;
        this.users = users;
    }

    @GetMapping("/seed")
    public String seed() {

        User user = new User();
        user.setEmail("monkey@monkeylove.com");
        user.setUsername("zgulde");
        user.setPassword("codeup123");
        users.save(user);

        List<Post> posts = Arrays.asList(
                new Post("Monkeys are people too", "Only 2% difference in our genetic makeup"),
                new Post("Chickens love", "Affectionate chickens and their wild owners"),
                new Post("Queer love is real love", "We deserve love too"),
                new Post("The power of life", "Each day is a gift")
        );

        for (Post post : posts) {
//            post.setUser(user);
        }
        postRepository.save(posts);
        return "Check the console.";
    }

    @GetMapping("/example-profile")
    public String profile() {
        User user = users.findOne(1l);

        System.out.println("Showing posts belonging to user " + user.getUsername());

        List<Post> posts = user.getPosts();

        for (Post post : posts) {
            System.out.println("  - " + post.getTitle());
        }

        return "Again, it's in the console.";
    }
}
