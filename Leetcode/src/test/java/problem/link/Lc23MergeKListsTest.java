package problem.link;

import org.junit.jupiter.api.Test;
import problem.link.node.ListNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc23MergeKListsTest {

    @Test
    void mergeKLists() {
        assertEquals(ListNode.parse("[1,1,2,3,4,4,5,6]"), new Lc23MergeKLists().mergeKLists(ListNode.parse2Dim("[[1,4,5],[1,3,4],[2,6]]")));
    }
}