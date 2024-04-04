package problem.link;

import org.junit.jupiter.api.Test;
import problem.link.node.ListNode;

class Lc21MergeTwoListsTest {

    @Test
    void mergeTwoLists() {
        new Lc21MergeTwoLists().mergeTwoLists(
                ListNode.parse("[1,2,4]"),
                ListNode.parse("[1,3,4]")
        );
    }
}