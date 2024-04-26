package problem.search.binary;

import java.util.*;

public class Lc981TimeMap {

    class TimeMap {

        private Map<String, List<Value>> map = new HashMap<>();

        public TimeMap() {

        }

        public void set(String key, String value, int timestamp) {
            map.computeIfAbsent(key, i -> new ArrayList<>(4))
                    .add(new Value(value, timestamp));
        }

        public String get(String key, int timestamp) {
            List<Value> values = map.get(key);
            if (Objects.isNull(values) || values.isEmpty()) {
                return "";
            }
            int left = 0;
            int right = values.size();
            while (left < right) {
                int mid = (left + right) / 2;
                if (values.get(mid).timestamp <= timestamp) {
                    left = mid + 1;
                    continue;
                }
                right = mid;
            }
            if (left == 0) {
                return "";
            }
            return values.get(left - 1).value;
        }

        private static class Value {

            private String value;
            private int timestamp;

            public Value(String value, int timestamp) {
                this.value = value;
                this.timestamp = timestamp;
            }
        }
    }

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
}
