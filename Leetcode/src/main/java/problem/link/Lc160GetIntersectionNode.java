package problem.link;

import problem.link.node.ListNode;

import java.util.Objects;

public class Lc160GetIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode nodeA = headA;
        int sizeA = 0;
        while (Objects.nonNull(nodeA)) {
            sizeA++;
            nodeA = nodeA.next;
        }
        ListNode nodeB = headB;
        int sizeB = 0;
        while (Objects.nonNull(nodeB)) {
            sizeB++;
            nodeB = nodeB.next;
        }
        nodeA = headA;
        nodeB = headB;
        if (sizeA > sizeB) {
            for (int i = 0; i < sizeA - sizeB; i++) {
                nodeA = nodeA.next;
            }
        } else {
            for (int i = 0; i < sizeB - sizeA; i++) {
                nodeB = nodeB.next;
            }
        }
        while (nodeA != nodeB) {
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
        return nodeB;
    }

}
