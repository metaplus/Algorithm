package base;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import problem.UniquePathsII;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: Jingxing Xu
 * @Date: 2019/9/14 0:16
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AlgorithmTestBaseTest extends AlgorithmTestBase<UniquePathsII> {

    private Integer round1 = null;
    private Integer round2 = null;

    @Test
    @Order(3)
    void setFinishedIfLifeCycleIsPerClass() {
        assertEquals(round1, 45312);
        assertEquals(round2, 2222);
    }

    @Test
    @Order(2)
    void setRound2() {
        assertEquals(round1, 45312);
        assertNull(round2);
        round2 = 2222;
    }

    @Test
    @Order(1)
    void setRound1() {
        assertNull(round1);
        assertNull(round2);
        round1 = 45312;
    }
}
