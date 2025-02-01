package problem.link;

import org.junit.jupiter.api.Test;
import problem.link.node.ListNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc25ReverseKGroupTest {

    @Test
    void reverseKGroup() {
        assertEquals(ListNode.parse("[3,2,1,4,5]"), new Lc25ReverseKGroup().reverseKGroup(
                ListNode.parse("[1,2,3,4,5]"), 3));
        assertEquals(ListNode.parse("[2,1,4,3,5]"), new Lc25ReverseKGroup().reverseKGroup(
                ListNode.parse("[1,2,3,4,5]"), 2));
    }
}