package com.game.rockpaperscissor.service.impl;

import com.game.rockpaperscissor.enums.GameResult;
import com.game.rockpaperscissor.models.Player;
import com.game.rockpaperscissor.service.IGameService;
import lombok.extern.slf4j.Slf4j;

/**
 * The class execute the core logic of Game.
 */
@Slf4j
public class GameServiceImpl implements IGameService {

    /**
     * The method will execute the core Logic of Game - Given the two players picks which player will win the game.
     * @param playerOne The first value
     * @param playerTwo The second value
     * @return GameResult - WON - playerOne Won, LOST - PlayerTwo Won, TIE - if Game is Tie.
     * @see Player
     */
    @Override
    public GameResult executeGame(Player playerOne, Player playerTwo) {
        log.debug("Getting the Result for the Player: {} and Signal: {}",
                playerOne.getName(),
                playerOne.getSignal().name());
        return playerOne.getSignal().getResult(playerTwo.getSignal());
    }
}
