package org.argo.algorithm.platform.leetcode.solution.queue;

import org.argo.algorithm.platform.leetcode.solution.queue.DesignCircularQueue.MyCircularQueue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DesignCircularQueueTest {

    @Test
    void case2() {
        MyCircularQueue queue = new MyCircularQueue(3);
        assertTrue(queue.enQueue(1));
        assertTrue(queue.enQueue(2));
        assertTrue(queue.enQueue(3));
        assertFalse(queue.enQueue(4));
    }
}