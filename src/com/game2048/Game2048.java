package com.game2048;

import com.javarush.engine.cell.*;

public class Game2048 extends Game {
    private static final int SIDE = 4;
    private int[][] gameField = new int[SIDE][SIDE];

    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
        drawScene();
    }

    private void createGame() {
        createNewNumber();
        createNewNumber();
    }

    private void drawScene() {
        for (int x = 0; x < gameField.length; x++) {
            for (int y = 0; y < gameField[x].length; y++) {
                setCellColoredNumber(x, y, gameField[y][x]);
            }
        }
    }

    private void createNewNumber() {
        int randomNumber = getRandomNumber(10);
        int x = getRandomNumber(SIDE);
        int y = getRandomNumber(SIDE);

        if (!(gameField[x][y] == 0)) {
            createNewNumber();
        } else {
            if (randomNumber == 9) {
                gameField[x][y] = 4;
            } else {
                gameField[x][y] = 2;
            }
        }
    }

    private Color getColorByValue(int value) {
        switch (value) {
            case 0: { return Color.WHITE; }
            case 2: { return Color.PLUM; }
            case 4: { return Color.PURPLE; }
            case 8: { return Color.AQUA; }
            case 16: { return Color.OLDLACE; }
            case 32: { return Color.GREEN; }
            case 64: { return Color.LAWNGREEN; }
            case 128: { return Color.ORANGE; }
            case 256: { return Color.CYAN; }
            case 512: { return Color.BROWN; }
            case 1024: { return Color.DEEPSKYBLUE; }
            case 2048: { return Color.LAVENDER; }
            default: return Color.PINK;
        }
    }

    private void setCellColoredNumber(int x, int y, int value) {
        if (value == 0) {
            setCellValueEx(x, y, getColorByValue(value), "");
        } else {
            setCellValueEx(x, y, getColorByValue(value), "" + value);
        }
    }

    private boolean compressRow(int[] row) {
        boolean compress = false;
        for (int i = 0; i < row.length ; i++) {
            if (row[i] == 0) {
                for (int j = i; j < row.length ; j++)
                    if (row[j] != 0) {
                        int tmp = row[j];
                        row[i] = tmp;
                        row[j] = 0;
                        compress = true;
                        break;
                    }
            }
        }
        return compress;
    }

    private boolean mergeRow(int[] row) {
        boolean merge = false;

        for (int i = 0; i < row.length - 1; i++) {
            if (row[i] != 0 && row[i] == row[i + 1]) {
                row[i] = row[i] + row[i];
                row[i + 1] = 0;
                merge = true;
            }
        }

        return merge;
    }

    @Override
    public void onKeyPress(Key key) {
        if (key == Key.LEFT) {
            moveLeft();
        } else if (key == Key.RIGHT) {
            moveRight();
        } else if (key == Key.UP) {
            moveUp();
        } else if (key == Key.DOWN) {
            moveDown();
        }
    }

    private void moveLeft() {

    }

    private void moveRight() {

    }

    private void moveUp() {

    }

    private void moveDown() {

    }
}

