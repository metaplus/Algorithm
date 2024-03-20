package problem.tree;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Lc529UpdateBoardTest {

    @Test
    void updateBoard() {
        assertArrayEquals(ArrayParse.parse2DCharArray("[[\"1\",\"M\",\"M\",\"2\",\"B\",\"B\",\"B\",\"B\"],[\"E\",\"E\",\"M\",\"2\",\"B\",\"B\",\"B\",\"B\"],[\"E\",\"E\",\"2\",\"1\",\"B\",\"B\",\"B\",\"B\"],[\"E\",\"M\",\"1\",\"B\",\"B\",\"B\",\"B\",\"B\"],[\"1\",\"2\",\"2\",\"1\",\"B\",\"B\",\"B\",\"B\"],[\"B\",\"1\",\"M\",\"1\",\"B\",\"B\",\"B\",\"B\"],[\"B\",\"1\",\"1\",\"1\",\"B\",\"B\",\"B\",\"B\"],[\"B\",\"B\",\"B\",\"B\",\"B\",\"B\",\"B\",\"B\"]]"),
                new Lc529UpdateBoard().updateBoard(
                        ArrayParse.parse2DCharArray("[[\"E\",\"M\",\"M\",\"2\",\"B\",\"B\",\"B\",\"B\"],[\"E\",\"E\",\"M\",\"2\",\"B\",\"B\",\"B\",\"B\"],[\"E\",\"E\",\"2\",\"1\",\"B\",\"B\",\"B\",\"B\"],[\"E\",\"M\",\"1\",\"B\",\"B\",\"B\",\"B\",\"B\"],[\"1\",\"2\",\"2\",\"1\",\"B\",\"B\",\"B\",\"B\"],[\"B\",\"1\",\"M\",\"1\",\"B\",\"B\",\"B\",\"B\"],[\"B\",\"1\",\"1\",\"1\",\"B\",\"B\",\"B\",\"B\"],[\"B\",\"B\",\"B\",\"B\",\"B\",\"B\",\"B\",\"B\"]]"),
                        ArrayParse.parseIntArray("[0,0]")
                ));
        assertArrayEquals(ArrayParse.parse2DCharArray("[[\"B\",\"1\",\"E\",\"1\",\"B\"],[\"B\",\"1\",\"M\",\"1\",\"B\"],[\"B\",\"1\",\"1\",\"1\",\"B\"],[\"B\",\"B\",\"B\",\"B\",\"B\"]]"),
                new Lc529UpdateBoard().updateBoard(
                        ArrayParse.parse2DCharArray("[[\"E\",\"E\",\"E\",\"E\",\"E\"],[\"E\",\"E\",\"M\",\"E\",\"E\"],[\"E\",\"E\",\"E\",\"E\",\"E\"],[\"E\",\"E\",\"E\",\"E\",\"E\"]]"),
                        ArrayParse.parseIntArray("[3,0]")
                ));
    }
}