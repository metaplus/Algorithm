package problem.dp.bag;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc474FindMaxFormTest {

    @Test
    void findMaxForm() {
        assertEquals(3, new Lc474FindMaxForm().findMaxForm(ArrayParse.parseStringArray("[\"10\",\"0001\",\"111001\",\"1\",\"0\"]"), 3, 4));
        assertEquals(4, new Lc474FindMaxForm().findMaxForm(ArrayParse.parseStringArray("[\"10\",\"0001\",\"111001\",\"1\",\"0\"]"), 5, 3));
    }
}