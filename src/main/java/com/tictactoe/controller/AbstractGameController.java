package com.tictactoe.controller;

import com.tictactoe.model.player.Player;

import java.security.InvalidParameterException;

public abstract class AbstractGameController implements IGameController {

    protected void validatePlayerName(String playerName) {
        if (playerName == null || playerName.length() == 0) {
            throw new InvalidParameterException("Player name can not be null or empty");
        }
    }

    protected String getWinnerName(Player player) {
        if (player != null) {
            return player.getName();
        }
        return null;
    }
}
