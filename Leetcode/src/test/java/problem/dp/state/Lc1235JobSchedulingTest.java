package problem.dp.state;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc1235JobSchedulingTest {

    @Test
    void jobScheduling() {
        assertEquals(18, new Lc1235JobScheduling()
                .jobScheduling(ArrayParse.parseIntArray("[4,2,4,8,2]"),
                        ArrayParse.parseIntArray("[5,5,5,10,8]"),
                        ArrayParse.parseIntArray("[1,2,8,10,4]")));
        assertEquals(150, new Lc1235JobScheduling()
                .jobScheduling(ArrayParse.parseIntArray("[1,2,3,4,6]"),
                        ArrayParse.parseIntArray("[3,5,10,6,9]"),
                        ArrayParse.parseIntArray("[20,20,100,70,60]")));
        assertEquals(6, new Lc1235JobScheduling()
                .jobScheduling(ArrayParse.parseIntArray("[1,1,1]"),
                        ArrayParse.parseIntArray("[2,3,4]"),
                        ArrayParse.parseIntArray("[5,6,4]")));
        assertEquals(120, new Lc1235JobScheduling()
                .jobScheduling(ArrayParse.parseIntArray("[1,2,3,3]"),
                        ArrayParse.parseIntArray("[3,4,5,6]"),
                        ArrayParse.parseIntArray("[50,10,40,70]")));
    }

}