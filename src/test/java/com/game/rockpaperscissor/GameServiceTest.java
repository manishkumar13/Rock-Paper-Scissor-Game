package com.game.rockpaperscissor;

import com.game.rockpaperscissor.enums.GameResult;
import com.game.rockpaperscissor.enums.GameSignals;
import com.game.rockpaperscissor.models.Player;
import com.game.rockpaperscissor.service.IGameService;
import com.game.rockpaperscissor.service.impl.GameServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GameServiceTest {

    private IGameService gameService;

    @Before
    public void setUp() throws Exception {
        gameService = new GameServiceImpl();
    }

    //Testcase: when Player1 player ROCK, and second player token is interchanging
    @Test
    public void testExecuteGameWhenPlayerPlayedROCK() {
        Player playerOne = generatePlayerInfo("Player1", GameSignals.ROCK);
        Player playerTwo = generatePlayerInfo("Player2", GameSignals.SCISSOR);

        Assert.assertEquals(GameResult.WON, gameService.executeGame(playerOne, playerTwo));

        playerTwo.setSignal(GameSignals.ROCK);
        Assert.assertEquals(GameResult.TIE, gameService.executeGame(playerOne, playerTwo));

        playerTwo.setSignal(GameSignals.PAPER);
        Assert.assertEquals(GameResult.LOST, gameService.executeGame(playerOne, playerTwo));
    }

    //Testcase: when Player1 player PAPER, check for all the playerTwo Options
    @Test
    public void testExecuteGameWhenPlayerPlayedPAPER() {
        Player playerOne = generatePlayerInfo("Player1", GameSignals.PAPER);
        Player playerTwo = generatePlayerInfo("Player2", GameSignals.ROCK);

        Assert.assertEquals(GameResult.WON, gameService.executeGame(playerOne, playerTwo));

        playerTwo.setSignal(GameSignals.PAPER);
        Assert.assertEquals(GameResult.TIE, gameService.executeGame(playerOne, playerTwo));

        playerTwo.setSignal(GameSignals.SCISSOR);
        Assert.assertEquals(GameResult.LOST, gameService.executeGame(playerOne, playerTwo));
    }

    //Testcase: when Player1 played SCISSOR, check for all the playerTwo Options
    @Test
    public void testExecuteGameWhenPlayerPlayedSCISSOR() {
        Player playerOne = generatePlayerInfo("Player1", GameSignals.SCISSOR);
        Player playerTwo = generatePlayerInfo("Player2", GameSignals.PAPER);

        Assert.assertEquals(GameResult.WON, gameService.executeGame(playerOne, playerTwo));

        playerTwo.setSignal(GameSignals.SCISSOR);
        Assert.assertEquals(GameResult.TIE, gameService.executeGame(playerOne, playerTwo));

        playerTwo.setSignal(GameSignals.ROCK);
        Assert.assertEquals(GameResult.LOST, gameService.executeGame(playerOne, playerTwo));
    }

    private Player generatePlayerInfo(String playerName, GameSignals gameToken) {
        Player player = new Player(playerName);
        player.setSignal(gameToken);
        return player;
    }
}
