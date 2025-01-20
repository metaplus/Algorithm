package problem.array.pointer;

public class Lc1535GetWinner {

    public int getWinner(int[] arr, int k) {
        int left = 0;
        int right = 1;
        int remain = k;
        while (right < arr.length && remain > 0) {
            if (arr[left] >= arr[right]) {
                right++;
                remain--;
                continue;
            }
            left = right;
            right++;
            remain = k - 1;
        }
        return arr[left];
    }
}
