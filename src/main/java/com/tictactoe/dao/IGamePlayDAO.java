package com.tictactoe.dao;

import com.tictactoe.model.Board;
import com.tictactoe.model.Cell;
import com.tictactoe.model.player.Player;

public interface IGamePlayDAO {

    void makeTurn(String gameID, Player player, Cell cell);

    String startGame(Player player1, Player player2);

    Player lastTurn(String gameID);

    Board getBoard(String gameID);

    Player getComputerPlayer(String gameID);
}
