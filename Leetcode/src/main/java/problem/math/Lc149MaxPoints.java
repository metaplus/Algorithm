package problem.math;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Lc149MaxPoints {

    public int maxPoints(int[][] points) {
        int lenMax = 1;
        Map<Integer, Map<Double, Integer>> dp = new HashMap<>();
        Arrays.sort(points, Comparator.comparingInt(arr -> arr[0]));
        for (int i = 1; i < points.length; i++) {
            for (int j = 0; j < i; j++) {
                double ratio = points[i][0] == points[j][0] ? Double.MAX_VALUE : ((double) points[i][1] - points[j][1]) / (points[i][0] - points[j][0]);
                int pre = dp.computeIfAbsent(j, k -> new HashMap<>(4))
                        .getOrDefault(ratio, 0);
                Integer len = dp.computeIfAbsent(i, k -> new HashMap<>(4))
                        .merge(ratio, pre > 0 ? pre + 1 : 2, Math::max  );
                lenMax = Math.max(len, lenMax);
            }
        }
        return lenMax;
    }
}
