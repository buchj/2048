package spw4.game2048;

public class GameImpl implements Game {
    final int WIDTH = 4;
    final int HEIGHT = 4;

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
        return 0;
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
        // to do ...
    }

    public void move(Direction direction) {
        // to do ...
    }
}
