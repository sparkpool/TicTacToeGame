package com.tictactoe.service;

import com.tictactoe.dao.GamePlayDAOImpl;
import com.tictactoe.dao.IGamePlayDAO;
import com.tictactoe.model.Cell;
import com.tictactoe.model.player.Player;
import com.tictactoe.model.Status;
import com.tictactoe.util.GameUtil;

import java.security.InvalidParameterException;

public class TwoPlayersGameServiceImpl implements IGameService {

    private final IGamePlayDAO gamePlayDAO = GamePlayDAOImpl.getInstance();

    @Override
    public Status makeTurn(String gameID, Player player, Cell cell) {
        Player lastPlayer = gamePlayDAO.lastTurn(gameID);
        if (lastPlayer != null && lastPlayer.getName().equals(player.getName())) {
            throw new InvalidParameterException("Wait for the next player to complete the turn");
        }
        gamePlayDAO.makeTurn(gameID, player, cell);
        return GameUtil.getStatus(gamePlayDAO.getBoard(gameID));
    }


    @Override
    public String startGame(Player player1, Player player2) {
        return gamePlayDAO.startGame(player1, player2);
    }

    @Override
    public String getGrid(String gameID) {
        return gamePlayDAO.getBoard(gameID).toString();
    }
}
