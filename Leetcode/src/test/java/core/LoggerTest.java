package core;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: Jingxing Xu
 * @Date: 2019/9/14 3:04
 */
public class LoggerTest {

    @Test
    void base() {
        Logger logger = LoggerFactory.getLogger(LoggerTest.class);
        assertNotNull(logger);
    }
}
