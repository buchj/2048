package spw4.game2048;

import java.util.Random;

public class GameImpl implements Game {
    final int WIDTH = 4;
    final int HEIGHT = 4;

    int[][] board = new int[WIDTH][HEIGHT];

    public GameImpl() {
        // to do ...
    }

    public int getMoves() {
        // to do ...
        return 0;
    }

    public int getScore() {
        // to do ...
        return 0;
    }

    public int getValueAt(int x, int y) {
        if(x < 0 || x >=WIDTH || y < 0 || y>=HEIGHT)throw new IllegalArgumentException();
        // to do ...
        return board[x][y];
    }


    public boolean isOver() {
        // to do ...
        return false;
    }

    public boolean isWon() {
        // to do ...
        return false;
    }

    @Override
    public String toString() {
        // to do ...
        return "";
    }

    public void initialize() {
        Random r = new Random();
        for (int i = 0; i < 2; i++)
        {
            int x=r.nextInt(WIDTH);
            int y=r.nextInt(HEIGHT);
            if(board[x][y]!=0){
                i--;
                continue;
            }
            else{
                board[x][y]=2;
            }
        }
    }

    public void move(Direction direction) {
        // to do ...
    }
}
