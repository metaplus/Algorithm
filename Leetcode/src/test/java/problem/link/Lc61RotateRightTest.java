package problem.link;

import org.junit.jupiter.api.Test;
import problem.link.node.ListNode;

class Lc61RotateRightTest {

    @Test
    void rotateRight() {
        new Lc61RotateRight().rotateRight(ListNode.parse("1,2,3,4,5"), 2);
    }
}