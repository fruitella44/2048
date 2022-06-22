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
                setCellColor(x, y, Color.PINK);
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
}
