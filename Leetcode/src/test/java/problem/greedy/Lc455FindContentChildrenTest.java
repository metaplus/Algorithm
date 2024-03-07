package problem.greedy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Lc455FindContentChildrenTest {

    @Test
    void findContentChildren() {
        assertEquals(2, new Lc455FindContentChildren().findContentChildren(new int[]{10,9,8,7}, new int[]{5,6,7,8}));
        assertEquals(1, new Lc455FindContentChildren().findContentChildren(new int[]{3, 2, 1}, new int[]{1, 1}));
    }
}