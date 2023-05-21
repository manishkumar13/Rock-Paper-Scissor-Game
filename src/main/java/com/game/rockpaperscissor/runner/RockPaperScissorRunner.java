package com.game.rockpaperscissor.runner;

import com.game.rockpaperscissor.constants.Constants;
import com.game.rockpaperscissor.exceptions.InvalidArgumentException;
import com.game.rockpaperscissor.service.Game;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

/**
 * Main Driver Class to start the Game. Take input from the command prompt and calls Game Class to execute the game.
 *
 * @see Game
 */
@Component
@Slf4j
public class RockPaperScissorRunner implements CommandLineRunner {

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello Player!!, Please enter your name to start the Game: ");
        String input = scanner.nextLine();
        log.info("Hello {} !!", input);

        Game game = Game.startGame(input);

        while (!Constants.END_GAME.contains(input.toUpperCase())) {
            System.out.println("Please Enter the number, Here 0 - \"Rock\", 1 - \"Paper\", 2 - \"Scissor\", Or Enter \"Exit or End\" to end the game");
            input = scanner.nextLine();
            if(Constants.END_GAME.contains(input.toUpperCase())) continue;
            try {
                game.play(input);
            } catch (InvalidArgumentException ignored) {

            }
        }
    }
}
