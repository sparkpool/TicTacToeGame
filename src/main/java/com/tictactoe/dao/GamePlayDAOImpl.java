package com.tictactoe.dao;

import com.tictactoe.exceptions.InvalidCellException;
import com.tictactoe.model.Board;
import com.tictactoe.model.Cell;
import com.tictactoe.model.player.Player;

import java.security.InvalidParameterException;
import java.util.*;

public class GamePlayDAOImpl implements IGamePlayDAO {

    private static final GamePlayDAOImpl INSTANCE = new GamePlayDAOImpl();

    private GamePlayDAOImpl() {
    }

    public static GamePlayDAOImpl getInstance() {
        return INSTANCE;
    }

    private final Map<String, Game> GAMES = new HashMap<>();

    @Override
    public void makeTurn(String gameID, Player player, Cell cell) {
        Game game = this.getGame(gameID);
        this.validateCell(cell, game.getBoard());
        Player existingPlayer = game.getBoard().getPlayerOnCell(cell);
        if (existingPlayer != null) {
            throw new InvalidCellException("This cell is already used");
        }
        game.getBoard().updateCell(cell, player);
        game.setLastTurn(player);
    }

    private void validateCell(Cell cell, Board board) {
        board.validateCell(cell);
    }

    @Override
    public String startGame(Player player1, Player player2) {
        if (player1 == null || player2 == null) {
            throw new InvalidParameterException("Players can not be null to start the game");
        }
        String gameID = UUID.randomUUID().toString();
        GAMES.put(gameID, new Game(gameID, player1, player2));
        return gameID;
    }

    @Override
    public Player lastTurn(String gameID) {
        final Game game = this.getGame(gameID);
        return game.getLastTurn();
    }

    @Override
    public Board getBoard(String gameID) {
        final Game game = this.getGame(gameID);
        return game.getBoard();
    }

    @Override
    public Player getComputerPlayer(String gameID) {
        Game game = this.getGame(gameID);
        return game.getPlayer2();
    }

    private Game getGame(String gameID) {
        if (gameID == null || gameID.length() == 0) {
            throw new InvalidParameterException("GAmeID can not be null or empty");
        }
        Game game = this.GAMES.get(gameID);
        if (game == null) {
            throw new InvalidParameterException(String.format("Invalid GameID : %s", gameID));
        }
        return game;
    }


}
