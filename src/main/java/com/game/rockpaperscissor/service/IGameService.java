package com.game.rockpaperscissor.service;

import com.game.rockpaperscissor.enums.GameResult;
import com.game.rockpaperscissor.models.Player;

/**
 * An interface for Game, to implement the logic how game will decide the result.
 */
public interface IGameService {

    /**
     * interface method to execute the core Logic of Game - Given the two players picks which player will win the game.
     * @param playerOne
     * @param playerTwo
     * @return GameResult
     * @see Player
     */
    GameResult executeGame(Player playerOne, Player playerTwo);
}
