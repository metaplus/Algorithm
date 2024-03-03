package problem;

import com.google.common.collect.Lists;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.junit.jupiter.api.Test;
import problem.dp.Lc120MinimumTotal;

import static org.junit.jupiter.api.Assertions.*;

class Lc120MinimumTotalTest {

    @Test
    void minimumTotal() {
        assertEquals(0, new Lc120MinimumTotal()
                .minimumTotal(FastList.newListWith(
                        FastList.newListWith(-1),
                        FastList.newListWith(2, 3),
                        FastList.newListWith(1, -1, -1)
                )));
        assertEquals(-10, new Lc120MinimumTotal()
                .minimumTotal(FastList.newListWith(
                        FastList.newListWith(-10)
                )));
        assertEquals(11, new Lc120MinimumTotal()
                .minimumTotal(Lists.newArrayList(
                        Lists.newArrayList(2),
                        Lists.newArrayList(3, 4),
                        Lists.newArrayList(6, 5, 7),
                        Lists.newArrayList(4, 1, 8, 3)
                )));
    }
}