package com.codeup.blog.services;

import com.codeup.blog.models.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    private List<Post> posts;

    public PostService() {
        posts = new ArrayList<Post>();
        createPosts();
    }

    private void createPosts() {
        posts.add(new Post(1,"How to kiss a girl", "Be sweet and attentive. Get in real close. Kiss her lips like they are delicious strawberries that you cannot get enough of."));
        posts.add(new Post(2, "Love is ours too", "Creating a fair, equal, and fun society."));
        posts.add(new Post(3, "When young pans go out to play", "They have more fun than most"));
        posts.add(new Post(4, "Gay Boyfriends", "There is nothing better in life than having a gay boyfriend who want nothing sexual and everything mental & emotional"));
        posts.add(new Post(5,"Queer San Antonio", "Stats say that there should be 86,000 lgbtq peeps here. Lots more around than you suspected isn't there?"));
        posts.add(new Post(6, "Choosing between genders", "Why do I have to choose when I like both? And all the variations?"));
    }

    public List<Post> findAll() {
        return posts;
    }

    public Post save(Post post) {
        post.setID(posts.size() + 1);
        posts.add(post);
        return post;
    }

    public Post findOne(long id) {
        return posts.get((int) (id - 1));
    }
}
