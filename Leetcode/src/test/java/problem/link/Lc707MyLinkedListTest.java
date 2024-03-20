package problem.link;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc707MyLinkedListTest {

    @Test
    void testMyLinkedList() {
        Lc707MyLinkedList.MyLinkedList list = new Lc707MyLinkedList.MyLinkedList();
        list.addAtIndex(0, 10);
        list.addAtIndex(0, 20);
        list.addAtIndex(1, 30);
        assertEquals(20, list.get(0));
    }
}