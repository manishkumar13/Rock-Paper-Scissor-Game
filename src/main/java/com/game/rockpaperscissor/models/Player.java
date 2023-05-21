package com.game.rockpaperscissor.models;

import com.game.rockpaperscissor.enums.GameSignals;

/**
 * Class to Get the Basic Information of Players like - name of Player, what signal it has chosen
 */
public class Player {

    private final String name;
    private GameSignals signal;

    public Player(String name) {
        this.name = name;
    }

    public GameSignals getSignal() {
        return signal;
    }

    public void setSignal(GameSignals token) {
        this.signal = token;
    }

    public String getName() {
        return name;
    }
}
