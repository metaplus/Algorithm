package problem.array;

import java.util.Arrays;

public class Lc683KEmptySlots {

    public int kEmptySlots(int[] bulbs, int k) {
        int[] days = new int[bulbs.length];
        for (int i = 0; i < bulbs.length; i++) {
            days[bulbs[i] - 1] = i + 1;
        }
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int day = Integer.MAX_VALUE;
        int[] idx = new int[20001];
        Arrays.fill(idx, -1);
        for (int i = 0; i < days.length; i++) {
            idx[days[i]] = i;
            if (days[i] < min1) {
                min2 = min1;
                min1 = days[i];
            } else if (days[i] < min2) {
                min2 = days[i];
            }
            if (i - k - 2 >= 0) {
                idx[days[i - k - 2]] = -1;
                if (min1 == days[i - k - 2]) {
                    min1 = min2;
                    for (int j = min2 + 1; j < idx.length; j++) {
                        if (idx[j] >= 0) {
                            min2 = j;
                            break;
                        }
                    }
                } else if (min2 == days[i - k - 2]) {
                    for (int j = min2 + 1; j < idx.length; j++) {
                        if (idx[j] >= 0) {
                            min2 = j;
                            break;
                        }
                    }
                }
            }
            if (i - k - 1 >= 0) {
                int edge = Math.max(days[i], days[i - k - 1]);
                if (edge == min2) {
                    day = Math.min(day, edge);
                }
            }
        }
        return day != Integer.MAX_VALUE ? day : -1;
    }
}
