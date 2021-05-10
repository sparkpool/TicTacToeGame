package com.tictactoe.model;

public class Cell {

    private Integer x;
    private Integer y;

    public Cell(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Cell)) {
            return false;
        }
        Cell cell = (Cell) obj;
        if (!this.getX().equals(cell.getX())) {
            return false;
        }
        return this.getY().equals(cell.getY());
    }

    @Override
    public String toString() {
        return "Cell{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
