package problem.greedy;

public class Lc1217MinCostToMoveChips {

    public int minCostToMoveChips(int[] position) {
        int odd = 0;
        int even = 0;
        for (int i : position) {
            if (i % 2 == 1) {
                odd++;
                continue;
            }
            even++;
        }
        return Math.min(odd, even);
    }
}
