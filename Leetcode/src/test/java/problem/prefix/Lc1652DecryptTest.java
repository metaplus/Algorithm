package problem.prefix;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;
import problem.dp.prefix.Lc1652Decrypt;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Lc1652DecryptTest {

    @Test
    void decrypt() {
        assertArrayEquals(ArrayParse.parseIntArray("[12,5,6,13]"),
                new Lc1652Decrypt().decrypt(ArrayParse.parseIntArray("[2,4,9,3]"), -2));
        assertArrayEquals(ArrayParse.parseIntArray("[12,10,16,13]"),
                new Lc1652Decrypt().decrypt(ArrayParse.parseIntArray("[5,7,1,4]"), 3));
    }
}