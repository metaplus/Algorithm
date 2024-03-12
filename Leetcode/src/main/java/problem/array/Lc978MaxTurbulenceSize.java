package problem.array;

public class Lc978MaxTurbulenceSize {

    public int maxTurbulenceSize(int[] arr) {
        if (arr.length == 1) {
            return 1;
        }
        int left = 0;
        int lenMax = 0;
        for (int i = 0; i < arr.length; i++) {
            int len = i - left + 1;
            if (i < 1) {
                lenMax = 1;
                continue;
            }
            if (arr[i] == arr[i - 1]) {
                left = i;
                continue;
            }
            if (left >= i - 1) {
                lenMax = Math.max(len, lenMax);
                continue;
            }
            if (arr[i] > arr[i - 1]) {
                if (arr[i - 1] < arr[i - 2]) {
                    lenMax = Math.max(len, lenMax);
                    continue;
                }
                left = i - 1;
                continue;
            }
            if (arr[i - 1] > arr[i - 2]) {
                lenMax = Math.max(len, lenMax);
                continue;
            }
            left = i - 1;
        }
        return lenMax;
    }
}
