package com.tictactoe.enums;

import com.tictactoe.model.player.EasyComputerPlayer;
import com.tictactoe.model.player.MediumComputerPlayer;
import com.tictactoe.model.player.Player;

public enum EnumGameLevel {

    EASY {
        @Override
        public Player getPlayer() {
            return new EasyComputerPlayer("C");
        }
    },
    MEDIUM {
        @Override
        public Player getPlayer() {
            return new MediumComputerPlayer("C");
        }
    };

    public static Player getPlayer(String gameLevel) {
        for (EnumGameLevel level : EnumGameLevel.values()) {
            if (level.name().equals(gameLevel)) {
                return level.getPlayer();
            }
        }
        return null;
    }

    public abstract Player getPlayer();
}
