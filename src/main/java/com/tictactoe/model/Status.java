package com.tictactoe.model;

import com.tictactoe.model.player.Player;
import com.tictactoe.enums.EnumGameStatus;

public class Status {

    private EnumGameStatus gameStatus;
    private Player wonPlayer;
    private Board board;

    public Status(EnumGameStatus gameStatus, Player wonPlayer, Board board) {
        this.gameStatus = gameStatus;
        this.wonPlayer = wonPlayer;
        this.board = board;
    }

    public EnumGameStatus getGameStatus() {
        return gameStatus;
    }

    public Player getWonPlayer() {
        return wonPlayer;
    }

    public Board getBoard() {
        return board;
    }
}
