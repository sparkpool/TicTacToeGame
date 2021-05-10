package com.tictactoe.model;

import com.tictactoe.model.player.Player;

import java.security.InvalidParameterException;

public class Board {

    private final Player[][] grid = new Player[3][3];

    public Player getPlayerOnCell(Cell cell) {
        return this.grid[cell.getX()][cell.getY()];
    }

    public void validateCell(Cell cell) {
        int x = cell.getX();
        int y = cell.getY();
        boolean isValid = inRange(x, y);
        if (!isValid) {
            throw new InvalidParameterException("Coordinates in TicTacToe grid should be in range");
        }
    }

    public void updateCell(Cell cell, Player player) {
        this.grid[cell.getX()][cell.getY()] = player;
    }

    private boolean inRange(int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid.length) {
            return false;
        }
        return true;
    }

    public Player verticalPlayerWinner() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                if (this.grid[i][j] == null || !this.grid[i][j].equals(this.grid[i][j + 1])) {
                    break;
                }
                if (j == 1) {
                    return this.grid[i][j];
                }
            }
        }
        return null;
    }

    public Player horizontalPlayerWinner() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                if (this.grid[j][i] == null || !this.grid[j][i].equals(this.grid[j + 1][i])) {
                    break;
                }
                if (j == 1) {
                    return this.grid[j][i];
                }
            }
        }
        return null;
    }

    public Player diagonalPlayerWinner() {
        if (this.grid[0][0] != null && this.grid[0][0].equals(this.grid[1][1]) && this.grid[1][1].equals(this.grid[2][2])) {
            return this.grid[0][0];
        }
        if (this.grid[0][2] != null && this.grid[0][2].equals(this.grid[1][1]) && this.grid[1][1].equals(this.grid[2][0])) {
            return this.grid[0][0];
        }
        return null;
    }

    public boolean isGameDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (this.grid[i][j] == null) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (this.grid[i][j] == null) {
                    output.append("-1 ");
                } else {
                    output.append(this.grid[i][j].getName()).append(" ");
                }
            }
            output.append("\n");
        }
        return output.toString();
    }
}
