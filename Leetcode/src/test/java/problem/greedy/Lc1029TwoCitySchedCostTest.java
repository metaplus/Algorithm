package problem.greedy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Lc1029TwoCitySchedCostTest {

    @Test
    void twoCitySchedCost() {
        assertEquals(4723, new Lc1029TwoCitySchedCost()
                .twoCitySchedCost(new int[][]{
                        new int[]{70, 311},
                        new int[]{74, 927},
                        new int[]{732, 711},
                        new int[]{126, 583},
                        new int[]{857, 118},
                        new int[]{97, 928},
                        new int[]{975, 843},
                        new int[]{175, 221},
                        new int[]{284, 929},
                        new int[]{816, 602},
                        new int[]{689, 863},
                        new int[]{721, 888},
                }));
        assertEquals(110, new Lc1029TwoCitySchedCost()
                .twoCitySchedCost(new int[][]{
                        new int[]{10, 20},
                        new int[]{30, 200},
                        new int[]{400, 50},
                        new int[]{30, 20},
                }));


    }
}