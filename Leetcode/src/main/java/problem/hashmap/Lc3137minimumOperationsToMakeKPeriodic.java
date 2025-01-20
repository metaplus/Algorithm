package problem.hashmap;

import java.util.HashMap;
import java.util.Map;

public class Lc3137minimumOperationsToMakeKPeriodic {


    public int minimumOperationsToMakeKPeriodic(String word, int k) {
        Map<String, Integer> counts = new HashMap<>();
        int countMax = 0;
        for (int i = 0; i < word.length(); i += k) {
            String str = word.substring(i, i + k);
            countMax = Math.max(countMax, counts.merge(str, 1, Integer::sum));
        }
        int sum = 0;
        for (Integer value : counts.values()) {
            sum += value;
        }
        return sum - countMax;
    }
}
