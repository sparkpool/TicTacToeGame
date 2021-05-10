package com.tictactoe.service;

import com.tictactoe.model.Cell;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public class IntelligentMoveGeneratorService implements IMoveGenerator {

    private final Map<Integer, Cell> RANDOM_MAP = new HashMap<>();
    private final Random random = new Random();

    public IntelligentMoveGeneratorService() {
        int index = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                RANDOM_MAP.put(index++, new Cell(i, j));
            }
        }
    }

    @Override
    public Cell nextMove() {
        int randomNo = random.nextInt(RANDOM_MAP.size());
        Cell cell = RANDOM_MAP.get(randomNo);
        balanceMap(randomNo);
        return cell;
    }

    @Override
    public void remove(Cell cell) {
        Iterator<Map.Entry<Integer, Cell>> iterator = RANDOM_MAP.entrySet().iterator();
        Integer key = null;
        while (iterator.hasNext()) {
            Map.Entry<Integer, Cell> entry = iterator.next();
            if (entry.getValue().equals(cell)) {
                key = entry.getKey();
                break;
            }
        }
        if (key != null) {
            balanceMap(key);
        }
    }

    private void balanceMap(Integer index) {
        if (index == RANDOM_MAP.size() - 1) {
            RANDOM_MAP.remove(index);
            return;
        }
        Cell lastCell = RANDOM_MAP.get(RANDOM_MAP.size() - 1);
        RANDOM_MAP.remove(RANDOM_MAP.size() - 1);
        RANDOM_MAP.put(index, lastCell);
    }
}
