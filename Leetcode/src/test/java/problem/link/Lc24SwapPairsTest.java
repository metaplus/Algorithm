package problem.link;

import org.junit.jupiter.api.Test;
import problem.link.node.ListNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc24SwapPairsTest {

    @Test
    void swapPairs() {
        assertEquals(ListNode.parseText("[2,1,4,3]"),
                new Lc24SwapPairs().swapPairs(ListNode.parseText("[1,2,3,4]")));
    }
}