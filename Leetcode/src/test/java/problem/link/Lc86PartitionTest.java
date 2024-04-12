package problem.link;

import org.junit.jupiter.api.Test;
import problem.link.node.ListNode;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class Lc86PartitionTest {

    @Test
    void partition() {
        assertNotNull(new Lc86Partition().partition(ListNode.parse("[1,4,3,2,5,2]"), 3));
    }
}