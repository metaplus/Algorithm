package problem.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc978MaxTurbulenceSizeTest {

    @Test
    void maxTurbulenceSize() {
        assertEquals(2, new Lc978MaxTurbulenceSize().maxTurbulenceSize(new int[]{4,8,12,16}));
        assertEquals(5, new Lc978MaxTurbulenceSize().maxTurbulenceSize(new int[]{9, 4, 2, 10, 7, 8, 8, 1, 9}));
    }
}