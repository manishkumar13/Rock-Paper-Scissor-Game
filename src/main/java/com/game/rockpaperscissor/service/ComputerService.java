package com.game.rockpaperscissor.service;

import com.game.rockpaperscissor.enums.GameSignals;
import com.game.rockpaperscissor.helper.GameSignalAdapter;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * A Separate Class to implement all the various things computer can do.
 */
@Service
public class ComputerService {

    private static final Random random = new Random();

    /**
     * This method generate the Random GameSignal for Computer Player.
     *
     * @return GameSignal
     * @see GameSignalAdapter
     * @see GameSignals
     */
    public static GameSignals generateRandomGameSignal() {
        return GameSignalAdapter.adaptToGameSignalFromNumber(random.nextInt(3));
    }
}
