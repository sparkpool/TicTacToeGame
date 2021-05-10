package com.tictactoe.model.player;

import com.tictactoe.service.IMoveGenerator;
import com.tictactoe.enums.EnumGameLevel;

public interface Player {

    String getName();

    IMoveGenerator getGenerator();

    EnumGameLevel getLevel();
}
