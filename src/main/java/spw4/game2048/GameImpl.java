package spw4.game2048;

import java.util.Random;

public class GameImpl implements Game {
    final int SIDE_LENGTH = 4;


    int[][] board;
    int score=0;
    Random random=new Random();

    public GameImpl() {
        // to do ...
    }

    public int getMoves() {
        // to do ...
        return 0;
    }

    public int getScore() {
        // to do ...
        return score;
    }

    public int getValueAt(int x, int y) {
        if(x < 0 || x >= SIDE_LENGTH || y < 0 || y>=SIDE_LENGTH)throw new IllegalArgumentException();
        // to do ...
        return board[x][y];
    }

    public void setValueAt(int x, int y, int value) {
        board[x][y]=value;
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

    public void clearBoard(){
        board  = new int[SIDE_LENGTH][SIDE_LENGTH];
    }

    public void initialize() {
        clearBoard();

        for (int i = 0; i < 2; i++)
        {
            int x=random.nextInt(SIDE_LENGTH);
            int y=random.nextInt(SIDE_LENGTH);
            if(board[x][y]!=0){
                i--;
                continue;
            }
            else{
                board[x][y]= random.nextDouble()>0.9?4:2;
            }
        }
    }

    public void move(Direction direction) {
        boolean horizontal = direction==Direction.right||direction==Direction.left;
        boolean reverse = direction==Direction.left||direction==Direction.up;

        for (int i = 0; i < SIDE_LENGTH; i++)
        {

            for (int j = 0; j < SIDE_LENGTH; j++)
            {
                int oldX = reverse?i:SIDE_LENGTH-1-i;
                int oldY = reverse?j:SIDE_LENGTH-1-j;

                if(!horizontal){
                    int temp = oldX;
                    oldX=oldY;
                    oldY=temp;
                }

                int value = board[oldX][oldY];
                if(value==0)continue;

                int newX = !horizontal? (!reverse?oldX+1:oldX-1)  :oldX;
                int newY = horizontal? (!reverse?oldY+1:oldY-1) :oldY;
                if(newX < 0 || newX >= SIDE_LENGTH || newY < 0 || newY>=SIDE_LENGTH)continue;

                int valueOfTargetTile = board[newX][newY];

                if(valueOfTargetTile==0){
                    board[newX][newY]=value;
                    board[oldX][oldY]=0;
                    j-=2;
                }
                else if(valueOfTargetTile==value){
                   board[newX][newY]=value*2;
                    board[oldX][oldY]=0;
                    score+=value;
                }
                else{
                    continue;
                }
            }
        }
    }
}
