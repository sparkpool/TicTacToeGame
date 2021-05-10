package com.tictactoe.controller;

import com.tictactoe.controller.response.GameResponse;
import com.tictactoe.model.Cell;
import com.tictactoe.model.player.HumanPlayer;
import com.tictactoe.model.Status;
import com.tictactoe.service.IGameService;
import com.tictactoe.service.TwoPlayersGameServiceImpl;

public class HumansTicTaToeController extends AbstractGameController {

    private IGameService twoPlayersGameService = new TwoPlayersGameServiceImpl();

    @Override
    public String startGame(String playerName1, String playerNameOrGameLevel) {
        this.validatePlayerName(playerName1);
        this.validatePlayerName(playerNameOrGameLevel);
        return this.twoPlayersGameService.startGame(new HumanPlayer(playerName1), new HumanPlayer(playerNameOrGameLevel));
    }

    @Override
    public GameResponse makeTurn(String playerName, String gameID, int x, int y) {
        this.validatePlayerName(playerName);
        final Status status = this.twoPlayersGameService.makeTurn(gameID, new HumanPlayer(playerName), new Cell(x, y));
        return new GameResponse(status.getGameStatus(), status.getBoard().toString(), getWinnerName(status.getWonPlayer()));
    }

    @Override
    public String getGrid(String gameID) {
        return twoPlayersGameService.getGrid(gameID);
    }
}
