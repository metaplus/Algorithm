package problem.link;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import problem.link.node.ListNode;

class Lc234IsPalindromeTest extends Assertions {

    @Test
    void isPalindrome() {
        ListNode node = ListNode.parse("[1,2,2,1]");
        assertTrue(new Lc234IsPalindrome().isPalindrome(node));
    }
}