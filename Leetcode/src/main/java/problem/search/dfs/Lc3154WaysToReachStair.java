package problem.search.dfs;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Lc3154WaysToReachStair {


    public int waysToReachStair(int k) {
        return dfs(1, k, 1, false, new HashMap<>());
    }

    private int dfs(int stair, int k, int increment, boolean down, Map<Key, Integer> map) {
        Key key = new Key(stair, increment, down);
        Integer val = map.get(key);
        if (Objects.nonNull(val)) {
            return val;
        }
        int result = 0;
        if (stair == k) {
            result = 1;
        }
        if (stair != 0 && !down && stair - 1 <= k) {
            result += dfs(stair - 1, k, increment, true, map);
        }
        if (stair + increment <= k + 1) {
            result += dfs(stair + increment, k, increment * 2, false, map);
        }
        map.put(key, result);
        return result;
    }

    private static class Key {

        private final int stair;
        private final int increment;
        private final boolean down;

        public Key(int stair, int increment, boolean down) {
            this.stair = stair;
            this.increment = increment;
            this.down = down;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Key key = (Key) o;
            return stair == key.stair && increment == key.increment && down == key.down;
        }

        @Override
        public int hashCode() {
            int result = stair;
            result = 31 * result + increment;
            result = 31 * result + Boolean.hashCode(down);
            return result;
        }
    }
}
