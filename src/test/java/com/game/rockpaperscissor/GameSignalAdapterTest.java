package com.game.rockpaperscissor;

import com.game.rockpaperscissor.enums.GameSignals;
import com.game.rockpaperscissor.exceptions.InvalidArgumentException;
import com.game.rockpaperscissor.helper.GameSignalAdapter;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameSignalAdapterTest {

    @Test
    public void testValidInput() {
        assertThrows(InvalidArgumentException.class, () -> {
            GameSignalAdapter.adaptToGameSignalFromNumber(Integer.parseInt("5"));
        });
        Assert.assertEquals(
                GameSignalAdapter.adaptToGameSignalFromNumber(Integer.parseInt("0")), GameSignals.ROCK
        );
        Assert.assertEquals(
                GameSignalAdapter.adaptToGameSignalFromNumber(Integer.parseInt("1")), GameSignals.PAPER
        );
        Assert.assertEquals(
                GameSignalAdapter.adaptToGameSignalFromNumber(Integer.parseInt("2")), GameSignals.SCISSOR
        );
    }
}
