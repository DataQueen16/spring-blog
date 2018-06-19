package com.codeup.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@Controller
public class DiceController {

    @GetMapping("/rolldice")
    public String diceHome() {
        return "rolldice";
    }

    @GetMapping("/roll-dice/{num}")
    @ResponseBody
    public String randomDiceRoll(@PathVariable int num) {
        int roll = getRandomDice();
        String dice = "The computer rolled a " + roll + ".\n";
        String guess = "You guessed a " + num + ".\n";
        String goodGuess = "So lucky! You guessed right!";
        String wrong = "I'm so sorry. Better luck next time dear.";

        if (roll == num) {
            return guess + dice + goodGuess;
        }
        return dice + guess + wrong;
    }

    private static int getRandomDice() {
        Random r = new Random();
        return r.nextInt((6 - 1) + 1) + 1;
    }

}
