package problem.dp;

import java.util.Arrays;

public class Lc1575CountRoutes {

    private static final long MOD = 1000_000_000 + 7;

    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        long[][] paths = new long[fuel + 1][locations.length];
        for (int i = 0; i < fuel + 1; i++) {
            Arrays.fill(paths[i], -1);
        }
        long reduce = reduce(locations, start, finish, fuel, paths) + (start != finish ? 0 : 1);
        return Math.toIntExact(reduce % MOD);
    }

    public long reduce(int[] locations, int start, int finish, int fuel, long[][] paths) {
        if (Math.abs(locations[start] - locations[finish]) > fuel) {
            paths[fuel][start] = 0;
            return 0;
        }
        long total = 0;
        for (int i = 0; i < locations.length; i++) {
            if (i == start) {
                continue;
            }
            int fuel1 = fuel - Math.abs(locations[i] - locations[start]);
            if (fuel1 < 0) {
                continue;
            }
            if (paths[fuel1][i] != -1) {
                total += paths[fuel1][i];
                continue;
            }
            long count = 0;
            if (i == finish) {
                count += 1;
            }
            if (fuel1 > 0) {
                long reduce = reduce(locations, i, finish, fuel1, paths);
                count += reduce;
            }
            paths[fuel1][i] = count % MOD;
            total += count;
        }
        return total;
    }
}
