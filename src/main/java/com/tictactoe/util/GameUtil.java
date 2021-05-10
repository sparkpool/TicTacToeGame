package com.tictactoe.util;

import com.tictactoe.model.Board;
import com.tictactoe.model.player.Player;
import com.tictactoe.model.Status;
import com.tictactoe.enums.EnumGameStatus;

import java.security.InvalidParameterException;

public final class GameUtil {

    public static Status getStatus(final Board board) {
        if (board == null) {
            throw new InvalidParameterException("Input Board can not be null");
        }
        Player player = board.diagonalPlayerWinner();
        if (player != null) {
            return new Status(EnumGameStatus.FINISHED, player, board);
        }
        player = board.verticalPlayerWinner();
        if (player != null) {
            return new Status(EnumGameStatus.FINISHED, player, board);
        }
        player = board.horizontalPlayerWinner();
        if (player != null) {
            return new Status(EnumGameStatus.FINISHED, player, board);
        }
        if (board.isGameDraw()) {
            return new Status(EnumGameStatus.FINISHED, null, board);
        }
        return new Status(EnumGameStatus.IN_PROGRESS, null, board);
    }
}
