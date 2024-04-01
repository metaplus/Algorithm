package problem.tree;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc909SnakesAndLaddersTest {

    @Test
    void snakesAndLadders() {
        assertEquals(-1, new Lc909SnakesAndLadders()
                .snakesAndLadders(ArrayParse.parse2DIntArray("[[-1,1,1,1],[-1,7,1,1],[1,1,1,1],[-1,1,9,1]]")));
        assertEquals(-1, new Lc909SnakesAndLadders()
                .snakesAndLadders(ArrayParse.parse2DIntArray("[[1,1,-1],[1,1,1],[-1,1,1]]")));
        assertEquals(5, new Lc909SnakesAndLadders()
                .snakesAndLadders(ArrayParse.parse2DIntArray("[[-1,-1,-1,-1,-1,-1,-1,-1,-1,79,-1,-1,-1],[-1,-1,-1,-1,109,-1,-1,-1,-1,-1,86,-1,-1],[-1,-1,115,148,-1,-1,25,-1,10,-1,16,7,25],[-1,-1,61,-1,91,75,-1,-1,-1,-1,-1,-1,79],[-1,42,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,56,-1,34,-1,13,-1,-1,-1],[-1,110,-1,96,105,-1,-1,-1,40,-1,-1,-1,-1],[-1,-1,114,-1,-1,12,-1,32,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1,-1,44,-1,-1,13,25,49],[-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1],[166,59,3,-1,27,-1,-1,-1,-1,-1,-1,-1,-1],[-1,99,-1,-1,-1,-1,-1,-1,70,-1,-1,-1,-1],[-1,-1,146,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1]]")));

        assertEquals(1, new Lc909SnakesAndLadders()
                .snakesAndLadders(ArrayParse.parse2DIntArray("[[-1,-1,2,-1],[14,2,12,3],[4,9,1,11],[-1,2,1,16]]")));


        assertEquals(4, new Lc909SnakesAndLadders()
                .snakesAndLadders(ArrayParse.parse2DIntArray("[[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,35,-1,-1,13,-1],[-1,-1,-1,-1,-1,-1],[-1,15,-1,-1,-1,-1]]")));


  }
}