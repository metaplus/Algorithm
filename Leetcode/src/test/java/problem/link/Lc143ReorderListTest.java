package problem.link;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import problem.link.node.ListNode;

class Lc143ReorderListTest extends Assertions {

    @Test
    void reorderList() {
        {
            ListNode node = ListNode.parseText("[1,2,3,4]");
            new Lc143ReorderList().reorderList(node);
            assertEquals(ListNode.parseText("[1,4,2,3]"), node);
        }
    }
}