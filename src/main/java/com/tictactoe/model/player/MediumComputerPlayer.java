package com.tictactoe.model.player;

import com.tictactoe.service.IMoveGenerator;
import com.tictactoe.service.IntelligentMoveGeneratorService;
import com.tictactoe.enums.EnumGameLevel;

public class MediumComputerPlayer implements Player {

    private String playerName;

    public MediumComputerPlayer(String playerName) {
        this.playerName = playerName;
    }

    @Override
    public String getName() {
        return this.playerName;
    }

    /**
     * Right now there is only one generator for easy and medium but we can change the implementation
     */
    @Override
    public IMoveGenerator getGenerator() {
        return new IntelligentMoveGeneratorService();
    }

    @Override
    public EnumGameLevel getLevel() {
        return EnumGameLevel.MEDIUM;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof MediumComputerPlayer)) {
            return false;
        }
        MediumComputerPlayer o = (MediumComputerPlayer) obj;
        return this.playerName.equals(o.getName());
    }

    @Override
    public String toString() {
        return playerName;
    }
}
