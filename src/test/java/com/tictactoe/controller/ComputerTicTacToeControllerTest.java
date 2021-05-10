package com.tictactoe.controller;

import com.tictactoe.controller.response.GameResponse;
import com.tictactoe.enums.EnumGameLevel;
import com.tictactoe.enums.EnumGameStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ComputerTicTacToeControllerTest {

    private ComputerTicTacToeController classToTest = new ComputerTicTacToeController();

    @Test
    public void TestStartGame_Success() {
        String gameID = classToTest.startGame("1", "2");
        assertNotNull(gameID);
    }

    @Test
    public void TestStartGame_InvalidGameLevel() {
        boolean isException = false;
        try {
            classToTest.startGame("1", "2");
        } catch (Exception e) {
            isException = true;
        }
        assertTrue(isException);
    }

    @Test
    public void TestPlayGame_Success() {
        String gameID = classToTest.startGame("1", EnumGameLevel.EASY.name());
        assertNotNull(gameID);
        GameResponse response = classToTest.makeTurn("1", gameID, 0, 0);
        assertNotNull(response);
        assertEquals(response.getStatus(), EnumGameStatus.IN_PROGRESS);
        assertNull(response.getPlayerName());
        assertTrue(response.getGrid().contains("C"));
    }
}
