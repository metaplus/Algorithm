package problem.link;

import org.junit.jupiter.api.Test;
import problem.link.node.ListNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc92ReverseBetweenTest {

    @Test
    void reverseBetween() {
        assertEquals(ListNode.parseText("[5,3]"), new Lc92ReverseBetween().reverseBetween(
                ListNode.parseText("[3,5]"), 1, 2));
        assertEquals(ListNode.parseText("[5]"), new Lc92ReverseBetween().reverseBetween(
                ListNode.parseText("[5]"), 1, 1));
        assertEquals(ListNode.parseText("[1,4,3,2,5]"), new Lc92ReverseBetween().reverseBetween(
                ListNode.parseText("[1,2,3,4,5]"), 2, 4));
    }
}