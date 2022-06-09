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

    @Test
    void testGetValueAtValidCoordinatesYieldsNoException(){
        List<Integer> values = new LinkedList<>();
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                values.add(game.getValueAt(i,j));
            }
        }
    }

    @ParameterizedTest
    @CsvSource({"-1,0","0,-1","4,1","1,4","5,6"})
    void testGetValueAtInvalidCoordinatesYieldsException(int x,int y){
        Assertions.assertThrows(IllegalArgumentException.class,()->game.getValueAt(x,y));
    }

}
