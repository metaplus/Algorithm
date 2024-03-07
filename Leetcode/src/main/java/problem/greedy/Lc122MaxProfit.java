package problem.greedy;

public class Lc122MaxProfit {

    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int buy = 0;
        boolean in = false;
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (in) {
                if (i + 1 == prices.length || prices[i] > prices[i + 1]) {
                    profit += (prices[i] - buy);
                    buy = 0;
                    in = false;
                }
                continue;
            }
            if (i + 1 < prices.length && prices[i] < prices[i + 1]) {
                buy = prices[i];
                in = true;
            }
        }
        return profit;
    }
}
