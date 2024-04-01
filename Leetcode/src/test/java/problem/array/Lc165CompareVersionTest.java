package problem.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc165CompareVersionTest {

    @Test
    void compareVersion() {
        assertEquals(0, new Lc165CompareVersion().compareVersion("1.0", "1.0.0"));
        assertEquals(0, new Lc165CompareVersion().compareVersion("1.0", "1"));
    }
}