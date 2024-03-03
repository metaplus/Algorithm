package problem.sort;

public class Lc768MaxChunksToSorted {

    public int maxChunksToSorted(int[] arr) {
        int[] left = new int[arr.length];
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            left[i] = max;
        }
        int[] right = new int[arr.length];
        int min = arr[arr.length - 1];
        for (int i = arr.length - 1; i > 0; i--) {
            min = Math.min(min, arr[i]);
            right[i] = min;
        }
       int chunk = 0;
        for (int i = 0; i < left.length - 1; i++) {
            if (right[i + 1] >= left[i]) {
                chunk++;
            }
        }
        return chunk + 1;
    }
}
