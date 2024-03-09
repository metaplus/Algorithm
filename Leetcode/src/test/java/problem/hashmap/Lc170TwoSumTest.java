package problem.hashmap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Lc170TwoSumTest {

    @Test
    void  twoSum(){
        Lc170TwoSum.TwoSum twoSum = new Lc170TwoSum.TwoSum();
        twoSum.add(3);
        twoSum.add(2);
        twoSum.add(1);
        assertFalse(twoSum.find(2));
    }
}