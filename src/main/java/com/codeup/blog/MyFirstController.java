package com.codeup.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyFirstController {

    @GetMapping("/say-hello")
    public @ResponseBody String myFirstSpringView() {
        return "Hello from Spring!";
    }

    @GetMapping("/say-goodbye")
    public @ResponseBody String mySecondSpringView(){
        return "Goodbye World!";
    }

    @GetMapping("/say-hello/{name}")
    public String sayHello(@PathVariable String name, Model model) {
        model.addAttribute("name", name);
        return String.format("Hello, %s", name);
    }

    @GetMapping("/flights/from/{from}/to/{to}")
    public @ResponseBody String getFlights(
            @PathVariable String from,
            @PathVariable String to
    ) {
        return String.format("Finding flights from %s to %s....", from, to);
    }

    @GetMapping("/increment/{n}")
    public @ResponseBody String incerement(@PathVariable int n) {
        return String.format("%d + 1", n, n + 1);
    }
}
