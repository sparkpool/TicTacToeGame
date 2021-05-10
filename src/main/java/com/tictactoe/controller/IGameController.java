package com.tictactoe.controller;

import com.tictactoe.controller.response.GameResponse;

public interface IGameController {

    String startGame(String playerName1, String playerNameOrGameLevel);

    GameResponse makeTurn(String playerName, String gameID, int x, int y);

    String getGrid(String gameID);
}
