package problem.link;

import org.junit.jupiter.api.Test;
import problem.link.node.ListNode;

import static org.junit.jupiter.api.Assertions.*;

class Lc148SortListTest {

    @Test
    void sortList() {
        assertEquals(ListNode.parse("[1,2,3,4]"),new Lc148SortList().mergeSort(ListNode.parse("[4,2,1,3]")));
    }
}