package problem.search.bfs;

import java.util.ArrayDeque;
import java.util.Deque;

public class Lc752OpenLock {
    public int openLock(String[] deadends, String target) {
        if (target.equals("0000")) {
            return 0;
        }
        boolean[] visit = new boolean[(int) (encode(9, 9, 9, 9) + 1)];
        Deque<int[]> deque = new ArrayDeque<>();
        int level = 0;
        deque.offer(new int[]{0, 0, 0, 0});
        long last = encode(parse(target));
        for (String deadend : deadends) {
            if (deadend.equals("0000")) {
                return -1;
            }
            visit[(int) encode(parse(deadend))] = true;
        }
        while (!deque.isEmpty()) {
            int size = deque.size();
            level++;
            while (size-- > 0) {
                int[] arr = deque.poll();
                for (int i = 0; i < arr.length; i++) {
                    int val = arr[i];
                    arr[i] = val - 1;
                    int key = (int) encode(arr);
                    if (!visit[key]) {
                        visit[key] = true;
                        if (key == last) {
                            return level;
                        }
                        deque.offer(arr.clone());
                    }
                    arr[i] = val + 1;
                    key = (int) encode(arr);
                    if (!visit[key]) {
                        visit[key] = true;
                        if (key == last) {
                            return level;
                        }
                        deque.offer(arr.clone());
                    }
                    arr[i] = val;
                }
            }
        }
        return -1;
    }

    private int[] parse(String text) {
        int[] arr = new int[4];
        for (int i = 0; i < text.length(); i++) {
            arr[i] = text.charAt(i) - '0';
        }
        return arr;
    }

    private long encode(int... arr) {
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                arr[i] += 10;
            } else if (arr[i] > 9) {
                arr[i] -= 10;
            }
            sum += ((long) arr[i]) << (4 * i);
        }
        return sum;
    }
}
