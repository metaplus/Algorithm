package problem.link;

import org.junit.jupiter.api.Test;
import problem.link.node.ListNode;

class Lc82DeleteDuplicatesTest {

    @Test
    void deleteDuplicates() {
        new Lc82DeleteDuplicates().deleteDuplicates(ListNode.parseText("[1,1,1,2,3]"));
    }
}