package problem.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Lc2250CountRectangles {

    public int[] countRectangles(int[][] rectangles, int[][] points) {
        Arrays.sort(rectangles, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        int[] counts = new int[points.length];
        for (int[] rectangle : rectangles) {

            for (int[] point : points) {
//                Collections.sort();
            }
        }

        return counts;
    }
}
