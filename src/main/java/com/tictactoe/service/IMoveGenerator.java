package com.tictactoe.service;

import com.tictactoe.model.Cell;

public interface IMoveGenerator {

    Cell nextMove();

    void remove(Cell cell);
}
