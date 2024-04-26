package problem.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc1017BaseNeg2Test {

    @Test
    void baseNeg2() {
        assertEquals("110", new Lc1017BaseNeg2().baseNeg2(2));
        assertEquals("111", new Lc1017BaseNeg2().baseNeg2(3));
    }
}