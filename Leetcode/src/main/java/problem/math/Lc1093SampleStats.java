package problem.math;

public class Lc1093SampleStats {

    public double[] sampleStats(int[] counts) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int mode = Integer.MAX_VALUE;
        int modeCount = 0;
        long arrCount = 0;
        long sum = 0;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == 0) {
                continue;
            }
            min = Math.min(min, i);
            max = Math.max(max, i);
            if (counts[i] > modeCount) {
                mode = i;
                modeCount = counts[i];
            }
            arrCount += counts[i];
            sum += (long) counts[i] * i;
        }
        double mean = ((double) sum) / arrCount;
        boolean odd = arrCount % 2 == 1;
        long halfCount = arrCount / 2;
        long[] acc = new long[counts.length];
        acc[0] = counts[0];
        if (acc[0] > halfCount) {
            return new double[]{min, max, mean, 0, mode};
        }
        for (int i = 1; i < counts.length; i++) {
            acc[i] += acc[i - 1] + counts[i];
            if (odd && acc[i] > halfCount) {
                return new double[]{min, max, mean, i, mode};
            }
            if (!odd && acc[i] > halfCount) {
                if (counts[i] > 1 && acc[i - 1] < halfCount) {
                    return new double[]{min, max, mean, i, mode};
                }
                for (int j = i - 1; j >= 0; j--) {
                    if (counts[j] > 0) {
                        return new double[]{min, max, mean, ((double) (i + j)) / 2, mode};
                    }
                }
            }
        }
        return null;
    }
}
