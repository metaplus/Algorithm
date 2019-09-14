package problem;

import base.AlgorithmTestBase;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: Jingxing Xu
 * @Date: 2019/9/14 18:01
 */
class ReverseStringTest extends AlgorithmTestBase<ReverseString> {

    private final Logger logger = LoggerFactory.getLogger(ReverseStringTest.class);

    @Test
    void reverseString() {
        Stream.of(
                Pair.of(new char[]{'h', 'e', 'l', 'l', 'o'}, new char[]{'o', 'l', 'l', 'e', 'h'})
        ).forEach(pair -> {
            char[] input = pair.getLeft();
            char[] output = pair.getRight();
            algorithm.reverseString(input);
            assertArrayEquals(input, output);
            logger.info("Input {}. Correct", input);
        });
    }
}