package com.game.rockpaperscissor;

import com.game.rockpaperscissor.exceptions.InvalidArgumentException;
import com.game.rockpaperscissor.helper.GameSignalAdapter;
import com.game.rockpaperscissor.service.Game;
import com.game.rockpaperscissor.service.IGameService;
import com.game.rockpaperscissor.service.impl.GameServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameTest {

    private Game game;
    IGameService gameService = Mockito.mock(GameServiceImpl.class);

    @Before
    public void setUp() throws Exception {
        game = Game.startGame("Player1");
    }

    //For the valid Input, gameService will be invoked once.
    @Test
    public void testPlayWhenPlayerPlayedValidInput() {
        game.setGameExecutor(gameService);

        game.play("0");
        Mockito.verify(gameService, Mockito.times(1)).executeGame(Mockito.any(), Mockito.any());
    }

    //When Player add input which is not [0, 1, 2], then GameExecutor will not be invoked as Game Precondition will fail
    @Test
    public void testPlayWhenPlayerPlayedInvalidInput() {
        game.setGameExecutor(gameService);
        assertThrows(InvalidArgumentException.class, () -> {
            game.play("3");
        });
    }

    //Test isValidNumber() Predicate's behaviour
    @Test
    public void testIsValidPredicateMethod() {
        Assert.assertTrue(game.isValidNumber("0"));
        Assert.assertTrue(game.isValidNumber("1"));
        Assert.assertTrue(game.isValidNumber("2"));
        Assert.assertFalse(game.isValidNumber("3"));
        Assert.assertFalse(game.isValidNumber("xyz"));
    }
}
