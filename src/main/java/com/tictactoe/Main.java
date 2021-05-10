package com.tictactoe;

import com.tictactoe.controller.ComputerTicTacToeController;
import com.tictactoe.controller.response.GameResponse;
import com.tictactoe.controller.HumansTicTaToeController;
import com.tictactoe.controller.IGameController;
import com.tictactoe.enums.EnumGameLevel;
import com.tictactoe.enums.EnumGameStatus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private final static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static IGameController controller = null;

    public static void main(String[] args) throws IOException {
        System.out.println("Press 0 for single player or 1 for double player");
        String player1 = "1";
        String player2 = "2";
        String gameId;
        if (readInt() == 0) {
            controller = new ComputerTicTacToeController();
            System.out.println("Enter one of the mode to play with computer : ");
            System.out.println("1. Easy");
            int gameLevel = readInt();
            String level;
            switch (gameLevel) {
                case 1:
                    level = EnumGameLevel.EASY.name();
                    break;
                default:
                    System.out.println("---------### Invalid Option for the mode #####--------");
                    return;

            }
            gameId = controller.startGame(player1, level);
            while (true) {
                try {
                    System.out.println("Enter Player coordinates separated by a space ");
                    String input = readString();
                    String[] coordinates = input.split(" ");
                    if (coordinates.length != 2) {
                        System.err.println("Enter coordinates in proper format ");
                        continue;
                    }
                    GameResponse response = controller.makeTurn(player1, gameId, Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1]));
                    System.out.println(response.getGrid());
                    if (response.getStatus() == EnumGameStatus.FINISHED) {
                        if (response.getPlayerName() != null) {
                            System.out.println("Player " + response.getPlayerName() + " won!!");
                        } else {
                            System.out.println("Player " + response.getPlayerName() + " won!!");
                        }
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("---------------------#### " + e.getMessage() + " #####---------------------");
                    System.out.println(controller.getGrid(gameId));
                }
            }
        } else {
            controller = new HumansTicTaToeController();
            gameId = controller.startGame(player1, player2);
            int i = 0;
            String player = player1;
            while (true) {
                try {
                    System.out.println("Enter Player " + player + " coordinates separated by a space ");
                    String input = readString();
                    String[] coordinates = input.split(" ");
                    if (coordinates.length != 2) {
                        System.err.println("Enter coordinates in proper format ");
                        continue;
                    }
                    GameResponse response = controller.makeTurn(player, gameId, Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1]));
                    System.out.println(response.getGrid());
                    if (response.getStatus() == EnumGameStatus.FINISHED) {
                        if (response.getPlayerName() != null) {
                            System.out.println("Player " + response.getPlayerName() + " won!!");
                        } else {
                            System.out.println("Player " + response.getPlayerName() + " won!!");
                        }
                        break;
                    }
                    i++;
                    if (i % 2 == 0) {
                        player = player1;
                    } else {
                        player = player2;
                    }
                } catch (Exception e) {
                    System.out.println("---------------------#### " + e.getMessage() + " #####---------------------");
                    System.out.println(controller.getGrid(gameId));
                }
            }
        }
        System.out.println("Game Finished, Thanks for playing!!");
    }

    private static int readInt() throws IOException {
        return Integer.parseInt(reader.readLine());
    }


    private static String readString() throws IOException {
        return reader.readLine();
    }
}
