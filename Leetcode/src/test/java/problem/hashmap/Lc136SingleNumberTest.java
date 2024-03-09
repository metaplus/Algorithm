package problem.hashmap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Lc136SingleNumberTest {

    @Test
    void singleNumber() {
        assertEquals(354, new Lc136SingleNumber()
                .singleNumber(new int[]{-336, 513, -560, -481, -174, 101, -997, 40, -527, -784, -283, -336, 513, -560, -481, -174, 101, -997, 40, -527, -784, -283, 354}));
    }
}