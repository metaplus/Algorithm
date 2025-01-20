package problem.dp;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.*;

class Lc152MaxProductTest {

    @Test
    void maxProduct() {
        assertEquals(-2,new Lc152MaxProduct().maxProduct(ArrayParse.parseIntArray("[-2]")));
        assertEquals(6,new Lc152MaxProduct().maxProduct(ArrayParse.parseIntArray("[2,3,-2,4]")));
        assertEquals(24,new Lc152MaxProduct().maxProduct(ArrayParse.parseIntArray("[-2,3,-4]")));
    }
}