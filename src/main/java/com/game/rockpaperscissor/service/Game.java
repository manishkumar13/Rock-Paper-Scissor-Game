package com.game.rockpaperscissor.service;

import com.game.rockpaperscissor.enums.GameResult;
import com.game.rockpaperscissor.enums.GameSignals;
import com.game.rockpaperscissor.exceptions.InvalidArgumentException;
import com.game.rockpaperscissor.helper.GameSignalAdapter;
import com.game.rockpaperscissor.models.Player;
import com.game.rockpaperscissor.service.impl.GameServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.function.Predicate;

@Slf4j
public class Game {

    private static final String COMPUTER = "Computer";

    private IGameService gameService;
    private final Player player1;
    private final Player player2;

    private Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        gameService = new GameServiceImpl();

    }

    public boolean isValidNumber(String number) {
        if (number.isEmpty()) return false;

        return "0".equals(number) || "1".equals(number) || "2".equals(number);
    }

    public static Game startGame(String playerOneName) {
        Game Game = new Game(new Player(playerOneName), new Player(COMPUTER));
        log.info("Started the Game");
        return Game;
    }

    public void setGameExecutor(IGameService gameService) {
        this.gameService = gameService;
    }

    /**
     * The method execute the game once the player has chosen with ROCK, PAPER, SCISSOR.
     *
     * @param playerInput - Player's Input, It can be in form of 0 - ROCK or 1 - PAPER or 2 - SCISSOR
     * @see GameSignals
     * @see GameSignalAdapter
     * @see GameServiceImpl
     */
    public void play(String playerInput) {
        /**
         * Step 1: Check if player has given the valid Input i.e. anything from {0 to 2}
         */
        if (!isValidNumber(playerInput)) {
            log.warn("Invalid Input, Please try again, valid input are [0, 1, 2]");
            throw new InvalidArgumentException("Invalid playerInput it should be either [0, 1, 2]");
        }

        /**
         * Step 2: Get the GameSignal for player and Update the Game Signal in Player Class.
         */
        GameSignals playerOneSignal = GameSignalAdapter.adaptToGameSignalFromNumber(Integer.parseInt(playerInput));
        player1.setSignal(playerOneSignal);

        /**
         * Step 3: Call the ComputerService to generate the Computer's GameSignal and Update the Player Two Details
         */
        GameSignals playerComputerSignal = ComputerService.generateRandomGameSignal();
        player2.setSignal(playerComputerSignal);

        log.info("You played: {} , Computer player played: {}", playerOneSignal, playerComputerSignal);

        GameResult gameResult = gameService.executeGame(player1, player2);

        if (GameResult.WON.equals(gameResult)) {
            System.out.println("CONGRATULATIONS !!, " + player1.getName() + " , You won!!");
        } else if (GameResult.LOST.equals(gameResult)) {
            System.out.println("OOPS !! You Lost , Better Luck Next Time !!");
        } else {
            System.out.println("It's TIE !!. You can try again");
        }
    }
}
