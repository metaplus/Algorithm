package problem.sort;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class Lc147InsertionSortListTest {

    @Test
    void insertionSortList() {
        new Lc147InsertionSortList()
                .insertionSortList(
                        new Lc147InsertionSortList.ListNode(1,
                                new Lc147InsertionSortList.ListNode(1)));
        new Lc147InsertionSortList()
                .insertionSortList(
                        new Lc147InsertionSortList.ListNode(4,
                                new Lc147InsertionSortList.ListNode(2,
                                        new Lc147InsertionSortList.ListNode(1,
                                                new Lc147InsertionSortList.ListNode(3)))));

    }
}