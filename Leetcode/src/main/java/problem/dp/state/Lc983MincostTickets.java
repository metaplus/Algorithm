package problem.dp.state;

import java.util.HashSet;
import java.util.Set;

public class Lc983MincostTickets {

    public int mincostTickets(int[] days, int[] costs) {
        int last = days[days.length - 1] + 1;
        int[] dp = new int[last + 1];
        Set<Integer> daysSet = new HashSet<>(days.length);
        for (int day : days) {
            daysSet.add(day);
        }
        for (int i = 1; i <= last; i++) {
            if (daysSet.contains(i)) {
                dp[i] = dp[i - 1] + costs[0];
                dp[i] = Math.min(dp[i], (i - 7 < 0 ? 0 : dp[i - 7]) + costs[1]);
                dp[i] = Math.min(dp[i], (i - 30 < 0 ? 0 : dp[i - 30]) + costs[2]);
                daysSet.remove(i);
                continue;
            }
            dp[i] = dp[i - 1];
        }
        return dp[dp.length - 1];
    }
}
