package spw4.game2048;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class TestGameImpl
{
    Game game;

    @BeforeEach
    void setup(){
        game = new GameImpl();
        game.initialize();
    }

    List<Integer> getValues(){
        List<Integer> values = new LinkedList<>();
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                values.add(game.getValueAt(i,j));
            }
        }
        return values;
    }

    //region 1: The board consists of 16 tiles (4 x 4).
    @Test
    void testGetValueAtValidCoordinatesYieldsNoException(){
        getValues();
    }

    @ParameterizedTest
    @CsvSource({"-1,0","0,-1","4,1","1,4","5,6"})
    void testGetValueAtInvalidCoordinatesYieldsException(int x,int y){
        Assertions.assertThrows(IllegalArgumentException.class,()->game.getValueAt(x,y));
    }
    //endregion

    //region 2: When starting the game, the board is initialized with 2 randomly positioned tiles.
    @Test
    void testBoardInitializesWith2Tiles(){
        List<Integer> values = getValues();
        Assertions.assertEquals(2,values.stream().filter((x)->x>0).count());
    }
    //endregion

    //region 3:The value of each new tile is randomly chosen from 2 and 4, whereby 2 has a higher probability of 90%.
    @Test
    void testBoardInitializesWithValidTileValues(){
        List<Integer> values = getValues();
        Assertions.assertEquals(2,values.stream().filter((x)->x==2||x==4).count());
    }

    @Test
    void testBoardInitializesWithCorrectRandomTileValuesInCorrectRandomSpots(){
        GameImpl newGame = new GameImpl();

        newGame.random=new RandomStub<Integer>(List.of(0,1,2,3),List.of(0.95,0.75));
        newGame.initialize();

        Assertions.assertEquals(4,newGame.getValueAt(0,1));
        Assertions.assertEquals(2,newGame.getValueAt(2,3));
    }
    //endregion

    
}
