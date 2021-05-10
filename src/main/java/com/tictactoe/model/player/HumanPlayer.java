package com.tictactoe.model.player;

import com.tictactoe.service.IMoveGenerator;
import com.tictactoe.enums.EnumGameLevel;

public class HumanPlayer implements Player {

    private String playerName;

    public HumanPlayer(String playerName) {
        this.playerName = playerName;
    }

    @Override
    public String getName() {
        return this.playerName;
    }

    @Override
    public IMoveGenerator getGenerator() {
        throw new UnsupportedOperationException("This operation is not valid for Human Player");
    }

    @Override
    public EnumGameLevel getLevel() {
        throw new UnsupportedOperationException("This operation is not valid for Human Player");
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof HumanPlayer)) {
            return false;
        }
        HumanPlayer o = (HumanPlayer) obj;
        return this.playerName.equals(o.getName());
    }

    @Override
    public String toString() {
        return playerName;

    }
}
