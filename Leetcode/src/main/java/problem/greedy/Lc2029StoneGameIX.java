package problem.greedy;

import java.util.ArrayList;
import java.util.List;

public class Lc2029StoneGameIX {

    // fa
    public boolean stoneGameIX(int[] stones) {
        List<Integer>[] buckets = new List[3];
        for (int stone : stones) {
            int mod = stone % 3;
            if (buckets[mod] == null) {
                buckets[mod] = new ArrayList<>();
            }
            buckets[mod].add(stone);
        }
        int sum = 0;
        for (int i = 0; i < stones.length; i++) {
            Integer remove = removeProcess(buckets, sum);
            if (remove == null) {
                return false;
            }
            sum += remove;
            if (++i < stones.length) {
                remove = removeProcess2(buckets, sum);
                if (remove == null) {
                    return true;
                }
                sum += remove;
            }
        }
        return false;
    }

    private static Integer removeProcess(List<Integer>[] buckets, int sum) {
        int mod = sum % 3;
        if (mod == 1 || sum == 0) {
            Integer remove = removeTail(buckets, 1);
            if (remove != null) {
                return remove;
            }
        }
        if (mod == 2 || sum == 0) {
            Integer remove = removeTail(buckets, 2);
            if (remove != null) {
                return remove;
            }
        }
        if (sum > 0) {
            Integer remove = removeTail(buckets, 0);
            if (remove != null) {
                return remove;
            }
        }
        return null;
    }

    private static Integer removeProcess2(List<Integer>[] buckets, int sum) {
        if (sum > 0) {
            Integer remove = removeTail(buckets, 0);
            if (remove != null) {
                return remove;
            }
        }
        int mod = sum % 3;
        if (mod == 1 || sum == 0) {
            Integer remove = removeTail(buckets, 1);
            if (remove != null) {
                return remove;
            }
        }
        if (mod == 2 || sum == 0) {
            Integer remove = removeTail(buckets, 2);
            if (remove != null) {
                return remove;
            }
        }
        return null;
    }




    private static Integer removeTail(List<Integer>[] buckets, int mod) {
        if (buckets[mod] != null && !buckets[mod].isEmpty()) {
            return buckets[mod].remove(buckets[mod].size() - 1);
        }
        return null;
    }
}
