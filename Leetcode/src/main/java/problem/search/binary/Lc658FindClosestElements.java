package problem.search.binary;

import java.util.*;

public class Lc658FindClosestElements {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        left--;
        for (int i = 0; i < k; i++) {
            if (left < 0) {
                right++;
                continue;
            }
            if (right > arr.length - 1) {
                left--;
                continue;
            }
            if (x - arr[left] <= arr[right] - x) {
                left--;
                continue;
            }
            right++;
        }
        List<Integer> result = new ArrayList<>(k);
        for (int i = left + 1; i < right; i++) {
            result.add(arr[i]);
        }
        return result;
    }

    public List<Integer> findClosestElements2(int[] arr, int k, int x) {
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

    public List<Integer> findClosestElements3(int[] arr, int k, int x) {
        PriorityQueue<Cell> queue = new PriorityQueue<>(k + 1, (a, b) -> {
            if (a.gap != b.gap) {
                return b.gap - a.gap;
            }
            return b.index - a.index;
        });
        int last = 0;
        for (int i = 0; i < arr.length; i++) {
            int gap = Math.abs(arr[i] - x);
            if (queue.size() < k) {
                queue.add(new Cell(i, arr[i], gap));
                last = i;
                continue;
            }
            if (gap >= queue.peek().gap) {
                if (arr[i] > x) {
                    break;
                }
                continue;
            }
            queue.remove();
            queue.add(new Cell(i, arr[i], gap));
            last = i;
        }
        List<Integer> res = new ArrayList<>(k);
        for (int i = last - k + 1; i <= last; i++) {
            res.add(arr[i]);
        }
        return res;
    }

    private class Cell {

        private int index;
        private int val;
        private int gap;

        public Cell(int index, int val, int gap) {
            this.index = index;
            this.val = val;
            this.gap = gap;
        }

        @Override
        public String toString() {
            return "Cell{" +
                    "index=" + index +
                    ", val=" + val +
                    ", gap=" + gap +
                    '}';
        }
    }
}
