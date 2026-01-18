package problem.dp;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Lc3542MinOperationsTest {

    @Test
    void minOperations() {
        assertEquals(1, new Lc3542MinOperations().minOperations(ArrayParse.parseIntArray("[0,2]")));
        assertEquals(3, new Lc3542MinOperations().minOperations(ArrayParse.parseIntArray("[3,1,2,1]")));
    }
}