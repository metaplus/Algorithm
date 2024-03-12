package problem.array;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Lc658FindClosestElements {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if (x <= arr[0]) {
            List<Integer> list = new ArrayList<>(k);
            for (int i = 0; i < k; i++) {
                list.add(arr[i]);
            }
            return list;
        }
        if (x >= arr[arr.length - 1]) {
            List<Integer> list = new ArrayList<>(k);
            for (int i = arr.length - k; i < arr.length; i++) {
                list.add(arr[i]);
            }
            return list;
        }
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                deque.add(i);
                break;
            }
            if (arr[i] > x && arr[i - 1] < x) {
                if (x - arr[i - 1] <= arr[i] - x) {
                    deque.add(i - 1);
                } else {
                    deque.add(i);
                }
                break;
            }
        }
        while (deque.size() < k) {
            int left = deque.getFirst();
            int right = deque.getLast();
            if (left == 0) {
                deque.addLast(right + 1);
                continue;
            }
            if (right == arr.length - 1) {
                deque.addFirst(left - 1);
                continue;
            }
            if (x - arr[left - 1] <= arr[right + 1] - x) {
                deque.addFirst(left - 1);
                continue;
            }
            deque.addLast(right + 1);
        }
        List<Integer> list = new ArrayList<>(k);
        for (Integer id : deque) {
            list.add(arr[id]);
        }
        return list;
    }
}
