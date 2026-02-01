package problem.search.dfs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc2928DistributeCandiesTest {

    @Test
    void distributeCandies() {
        assertEquals(10, new Lc2928DistributeCandies().distributeCandies(3, 3));
        assertEquals(3, new Lc2928DistributeCandies().distributeCandies(5, 2));
    }
}