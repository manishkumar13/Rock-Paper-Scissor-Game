package com.game.rockpaperscissor.enums;

import com.game.rockpaperscissor.service.IGameSignalService;


/**
 * Enum Class based on the number of Options, from which a person can choose from.
 * Each Signal write their own logic in which cases it can win or loss or tie.
 */
public enum GameSignals implements IGameSignalService {

    ROCK {
        @Override
        public GameResult getResult(GameSignals playerTwoSignal) {
            if (playerTwoSignal.equals(SCISSOR)) {
                return GameResult.WON;
            } else if (playerTwoSignal.equals(ROCK)) {
                return GameResult.TIE;
            } else {
                return GameResult.LOST;
            }
        }
    },

    PAPER {
        @Override
        public GameResult getResult(GameSignals playerTwoSignal) {
            if (playerTwoSignal.equals(ROCK)) {
                return GameResult.WON;
            } else if (playerTwoSignal.equals(PAPER)) {
                return GameResult.TIE;
            } else {
                return GameResult.LOST;
            }
        }
    },

    SCISSOR {
        @Override
        public GameResult getResult(GameSignals playerTwoSignal) {
            if (playerTwoSignal.equals(PAPER)) {
                return GameResult.WON;
            } else if (playerTwoSignal.equals(SCISSOR)) {
                return GameResult.TIE;
            } else {
                return GameResult.LOST;
            }
        }
    };
}
