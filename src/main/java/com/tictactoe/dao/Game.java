package com.tictactoe.dao;

import com.tictactoe.model.Board;
import com.tictactoe.model.player.Player;

public class Game {

    private String ID;
    private Board board;
    private Player player1;
    private Player player2;
    private Player lastTurn;

    public Game(String ID, Player player1, Player player2) {
        this.ID = ID;
        this.board = new Board();
        this.player1 = player1;
        this.player2 = player2;
    }


    public Board getBoard() {
        return board;
    }

    public Player getLastTurn() {
        return lastTurn;
    }

    public void setLastTurn(Player lastTurn) {
        this.lastTurn = lastTurn;
    }

    public Player getPlayer2() {
        return player2;
    }
}
