package problem.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Lc2671FrequencyTracker {


    static class FrequencyTracker {

        private Map<Integer, Integer> freq = new HashMap<>();
        private Map<Integer, Integer> count = new HashMap<>();


        public FrequencyTracker() {
        }

        public void add(int number) {
            freq.compute(number, (k, v) -> {
                if (Objects.isNull(v)) {
                    count.compute(1, (k1, v1) -> Objects.isNull(v1) ? 1 : v1 + 1);
                    return 1;
                }
                count.compute(v, (k1, v1) -> v1 == 1 ? null : v1 - 1);
                count.compute(v + 1, (k1, v1) -> Objects.isNull(v1) ? 1 : v1 + 1);
                return v + 1;
            });
        }

        public void deleteOne(int number) {
            freq.compute(number, (k, v) -> {
                if (Objects.isNull(v)) {
                    return null;
                }
                count.compute(v, (k1, v1) -> v1 == 1 ? null : v1 - 1);
                if (v > 1) {
                    count.compute(v - 1, (k1, v1) -> Objects.isNull(v1) ? 1 : v1 + 1);
                    return v - 1;
                }
                return null;
            });
        }

        public boolean hasFrequency(int frequency) {
            return count.containsKey(frequency);
        }
    }

/**
 * Your FrequencyTracker object will be instantiated and called as such:
 * FrequencyTracker obj = new FrequencyTracker();
 * obj.add(number);
 * obj.deleteOne(number);
 * boolean param_3 = obj.hasFrequency(frequency);
 */
}
