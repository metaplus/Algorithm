package problem.sort;

import java.util.Arrays;

public class Lc1122RelativeSortArray {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int min = arr2[0];
        int max = arr2[0];
        for (int i = 0; i < arr2.length; i++) {
            if (arr2[i] > max) {
                max = arr2[i];
                continue;
            }
            if (arr2[i] < min) {
                min = arr2[i];
            }
        }
        int[] pos = new int[max - min + 1];
        Arrays.fill(pos, -1);
        for (int i = 0; i < arr2.length; i++) {
            pos[arr2[i] - min] = i;
        }
        int partition = splitPartition(arr1, min, max, pos);
        int[] count = new int[max - min + 1];
        for (int i = 0; i < partition; i++) {
            count[arr1[i] - min]++;
        }
        int pre = 0;
        for (int i = 1; i < arr2.length; i++) {
            int add = count[arr2[i] - min];
            count[arr2[i] - min] = pre;
            pre += add;
        }
        int[] sort = new int[arr1.length];
        for (int i = 0; i < partition; i++) {
            sort[count[arr1[i] - min]] = arr1[i];
            count[arr1[i] - min]++;
        }
        countSort(arr1, sort, partition);
        return sort;
    }

    private int splitPartition(int[] arr1, int min, int max, int[] pos) {
        int count = 0;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] < min || arr1[i] > max) {
                continue;
            }
            if (pos[arr1[i] - min] < 0) {
                continue;
            }
            swap(arr1, i, count);
            count++;
        }
        return count;
    }

    private void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }
        int val = arr[i];
        arr[i] = arr[j];
        arr[j] = val;
    }

    private void countSort(int[] arr, int[] sort, int start) {
        if (arr.length - start < 2) {
            return;
        }
        int min = arr[start];
        int max = arr[start];
        for (int i = start; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                continue;
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        int[] count = new int[max - min + 1];
        for (int i = start; i < arr.length; i++) {
            count[arr[i] - min]++;
        }
        int pre = 0;
        for (int i = 0; i < count.length; i++) {
            int add = count[i];
            count[i] = pre;
            pre += add;
        }
        for (int i = start; i < arr.length; i++) {
            sort[count[arr[i] - min] + start] = arr[i];
            count[arr[i] - min]++;
        }
    }
}
