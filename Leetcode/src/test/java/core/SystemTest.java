package core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author: Jingxing Xu
 * @Date: 2019/9/14 1:54
 */
public class SystemTest {

    @Test
    void property() {
        assertEquals(System.getProperty("propertyName"), "propertyValue");
    }
}
