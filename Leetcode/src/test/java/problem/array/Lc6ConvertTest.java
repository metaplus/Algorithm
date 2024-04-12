package problem.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc6ConvertTest {

    @Test
    void convert() {
        assertEquals("PINALSIGYAHRPI", new Lc6Convert().convert("PAYPALISHIRING", 4));
    }
}