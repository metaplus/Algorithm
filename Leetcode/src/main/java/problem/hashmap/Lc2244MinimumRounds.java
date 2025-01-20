package problem.hashmap;

import java.util.HashMap;
import java.util.Map;

public class Lc2244MinimumRounds {

    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int task : tasks) {
            count.merge(task, 1, Integer::sum);
        }
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (entry.getValue() < 2) {
                return -1;
            }
            int val = entry.getValue();
            while (val > 0) {
                int mod3 = val % 3;
                if (mod3 == 0) {
                    sum += val / 3;
                    break;
                }
                val -= 2;
                sum++;
            }
        }
        return sum;
    }
}
