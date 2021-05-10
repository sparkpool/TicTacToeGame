package com.tictactoe.controller;

import com.tictactoe.controller.response.GameResponse;
import com.tictactoe.model.Cell;
import com.tictactoe.model.Status;
import com.tictactoe.model.player.HumanPlayer;
import com.tictactoe.model.player.Player;
import com.tictactoe.service.IGameService;
import com.tictactoe.service.SinglePlayerGameServiceImpl;
import com.tictactoe.enums.EnumGameLevel;

import java.security.InvalidParameterException;

public class ComputerTicTacToeController extends AbstractGameController {

    private final IGameService singlePlayerGameService = new SinglePlayerGameServiceImpl();

    @Override
    public String startGame(String playerName, String playerNameOrGameLevel) {
        this.validatePlayerName(playerName);
        Player player = this.getPlayerBasedOnLevel(playerNameOrGameLevel);
        return this.singlePlayerGameService.startGame(new HumanPlayer(playerName), player);
    }

    @Override
    public GameResponse makeTurn(String playerName, String gameID, int x, int y) {
        this.validatePlayerName(playerName);
        Status status = singlePlayerGameService.makeTurn(gameID, new HumanPlayer(playerName), new Cell(x, y));
        return new GameResponse(status.getGameStatus(), status.getBoard().toString(), this.getWinnerName(status.getWonPlayer()));
    }

    private Player getPlayerBasedOnLevel(String gameLevel) {
        Player player = EnumGameLevel.getPlayer(gameLevel);
        if (player == null) {
            throw new InvalidParameterException("Invalid Player Level");
        }
        return player;
    }

    @Override
    public String getGrid(String gameID) {
        return singlePlayerGameService.getGrid(gameID);
    }
}
