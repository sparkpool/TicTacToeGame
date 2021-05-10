package com.tictactoe.controller;

import com.tictactoe.controller.response.GameResponse;
import com.tictactoe.enums.EnumGameStatus;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.*;

public class HumansTicTacToeControllerTest {

    private HumansTicTaToeController classToTest = new HumansTicTaToeController();

    @Test
    public void TestStartGame_Success() {
        String gameID = classToTest.startGame("1", "2");
        assertNotNull(gameID);
    }

    @Test
    public void TestMakeTurn_Success() {
        String gameID = classToTest.startGame("1", "2");
        assertNotNull(gameID);
        GameResponse response = classToTest.makeTurn("1", gameID, 0, 0);
        assertNotNull(response);
        assertEquals(response.getStatus(), EnumGameStatus.IN_PROGRESS);
        response = classToTest.makeTurn("2", gameID, 1, 0);
        assertNotNull(response);
        assertEquals(response.getStatus(), EnumGameStatus.IN_PROGRESS);
        response = classToTest.makeTurn("1", gameID, 0, 1);
        assertNotNull(response);
        assertEquals(response.getStatus(), EnumGameStatus.IN_PROGRESS);
        response = classToTest.makeTurn("2", gameID, 1, 1);
        assertNotNull(response);
        assertEquals(response.getStatus(), EnumGameStatus.IN_PROGRESS);
        response = classToTest.makeTurn("1", gameID, 0, 2);
        assertNotNull(response);
        assertEquals(response.getStatus(), EnumGameStatus.FINISHED);
        assertEquals(response.getPlayerName(), "1");
    }

    @Test
    public void TestMakeTurn_InvalidTurn() {
        String gameID = classToTest.startGame("1", "2");
        assertNotNull(gameID);
        GameResponse response = classToTest.makeTurn("1", gameID, 0, 0);
        assertNotNull(response);
        assertEquals(response.getStatus(), EnumGameStatus.IN_PROGRESS);
        boolean isException = false;
        try {
            classToTest.makeTurn("1", gameID, 1, 0);
        } catch (InvalidParameterException e) {
            isException = true;
        }
        assertTrue(isException);
    }

    @Test
    public void TestMakeTurn_InvalidCell() {
        String gameID = classToTest.startGame("1", "2");
        assertNotNull(gameID);
        GameResponse response = classToTest.makeTurn("1", gameID, 0, 0);
        assertNotNull(response);
        assertEquals(response.getStatus(), EnumGameStatus.IN_PROGRESS);
        boolean isException = false;
        try {
            classToTest.makeTurn("1", gameID, 0, 0);
        } catch (InvalidParameterException e) {
            isException = true;
        }
        assertTrue(isException);
    }

    @Test
    public void TestMakeTurn_InvalidGame() {
        boolean isException = false;
        try {
            classToTest.makeTurn("1", "TestGameID", 0, 0);
        } catch (Exception e) {
            isException = true;
        }
        assertTrue(isException);
    }
}
