package com.game.rockpaperscissor.service;

import com.game.rockpaperscissor.enums.GameResult;
import com.game.rockpaperscissor.enums.GameSignals;

/**
 * An interface to implement the logic what will be the gameResult for each GameSignal.
 * Each GameSignal will write logic for themselves.
 */
public interface IGameSignalService {

    GameResult getResult(GameSignals playerTwoSignal);
}
