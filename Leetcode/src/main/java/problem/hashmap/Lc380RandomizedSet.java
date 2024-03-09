package problem.hashmap;

import java.util.*;

public class Lc380RandomizedSet {

    class RandomizedSet {

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> values = new ArrayList<>();
        Random random = new Random();

        public RandomizedSet() {

        }

        public boolean insert(int val) {
            Integer index = map.get(val);
            if (Objects.nonNull(index)) {
                return false;
            }
            map.put(val, values.size());
            values.add(val);
            return true;
        }

        public boolean remove(int val) {
            Integer index = map.get(val);
            if (Objects.isNull(index)) {
                return false;
            }
            int last = values.get(values.size() - 1);
            if (last == val) {
                values.remove(values.size() - 1);
                map.remove(val);
                return true;
            }
            values.set(index, last);
            values.remove(values.size() - 1);
            map.remove(val);
            map.put(last, index);
            return true;
        }

        public int getRandom() {
            return values.get(random.nextInt( values.size()));
        }
    }

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
}
