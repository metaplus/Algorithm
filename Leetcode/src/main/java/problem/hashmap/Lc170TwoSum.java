package problem.hashmap;

import java.util.HashMap;
import java.util.Map;

public class Lc170TwoSum {

 public   static class TwoSum {

        Map<Integer, Integer> map = new HashMap<>();

        public TwoSum() {
        }

        public void add(int number) {
            map.put(number, map.getOrDefault(number, 0) + 1);
        }

        public boolean find(int value) {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int sub = value - entry.getKey();
                if (sub != entry.getKey() && map.containsKey(sub)) {
                    return true;
                }
                if (sub == entry.getKey() && map.getOrDefault(sub, 0) > 1) {
                    return true;
                }
            }
            return false;
        }
    }

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
}
