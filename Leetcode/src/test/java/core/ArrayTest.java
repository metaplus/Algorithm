package core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * @Author: Jingxing Xu
 * @Date: 2019/9/14 18:05
 * `
 */
class ArrayTest {

    @Test
    void length() {
        char[] array = null;
        assertNull(array);
        array = new char[0];
        assertEquals(array.length, 0);
    }
}
