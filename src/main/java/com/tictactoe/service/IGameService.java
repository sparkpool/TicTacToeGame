package com.tictactoe.service;

import com.tictactoe.model.Cell;
import com.tictactoe.model.player.Player;
import com.tictactoe.model.Status;

public interface IGameService {

    Status makeTurn(String gameId, Player player, Cell cell);

    String startGame(Player player1, Player player2);

    String getGrid(String gameID);
}
