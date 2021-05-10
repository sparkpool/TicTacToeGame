package com.tictactoe.model.player;

import com.tictactoe.service.IMoveGenerator;
import com.tictactoe.service.IntelligentMoveGeneratorService;
import com.tictactoe.enums.EnumGameLevel;

public class EasyComputerPlayer implements Player {

    private String playerName;
    private IMoveGenerator moveGenerator;

    public EasyComputerPlayer(String playerName) {
        this.playerName = playerName;
        this.moveGenerator = new IntelligentMoveGeneratorService();
    }

    @Override
    public String getName() {
        return this.playerName;
    }

    @Override
    public IMoveGenerator getGenerator() {
        return moveGenerator;
    }

    @Override
    public EnumGameLevel getLevel() {
        return EnumGameLevel.EASY;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof EasyComputerPlayer)) {
            return false;
        }
        EasyComputerPlayer o = (EasyComputerPlayer) obj;
        return this.playerName.equals(o.getName());
    }

    @Override
    public String toString() {
        return playerName;
    }
}
