package com.game.rockpaperscissor.helper;

import com.game.rockpaperscissor.enums.GameSignals;
import com.game.rockpaperscissor.exceptions.InvalidArgumentException;
import lombok.extern.slf4j.Slf4j;

/**
 * An Adapter Class which converts the [0, 1, 2] into their respective GameToken
 */
@Slf4j
public class GameSignalAdapter {

    /**
     * This is a helper which convert the commandLine input - [0, 1, 2] into GameSignal Enum.
     *
     * @param playerInput Integer input of Player.
     * @return GameSignal
     * @throws InvalidArgumentException On invalid playerInput.
     * @see GameSignals
     */
    public static GameSignals adaptToGameSignalFromNumber(Integer playerInput) {
        switch (playerInput) {
            case 0:
                return GameSignals.ROCK;
            case 1:
                return GameSignals.PAPER;
            case 2:
                return GameSignals.SCISSOR;
            default:
                log.error("Invalid playerInput it should be either [0, 1, 2]");
                throw new InvalidArgumentException("Invalid playerInput it should be either [0, 1, 2]");

        }
    }
}
