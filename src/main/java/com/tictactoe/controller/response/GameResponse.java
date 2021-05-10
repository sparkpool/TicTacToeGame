package com.tictactoe.controller.response;

import com.tictactoe.enums.EnumGameStatus;

public class GameResponse {

    private EnumGameStatus status;
    private String grid;
    private String playerName;

    public GameResponse(EnumGameStatus status, String grid, String playerName) {
        this.status = status;
        this.grid = grid;
        this.playerName = playerName;
    }

    public EnumGameStatus getStatus() {
        return status;
    }

    public String getGrid() {
        return grid;
    }

    public String getPlayerName() {
        return playerName;
    }
}
