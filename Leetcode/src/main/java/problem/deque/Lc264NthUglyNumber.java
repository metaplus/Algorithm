package problem.deque;

import java.util.PriorityQueue;

public class Lc264NthUglyNumber {

    public int nthUglyNumber(int n) {
        PriorityQueue<Long> queue = new PriorityQueue<>();
        int id = 0;
        long last = 0;
        queue.offer(1L);
        while (id < n) {
            if (queue.peek() == last) {
                queue.remove();
                continue;
            }
            last = queue.remove();
            queue.add(last * 2);
            queue.add(last * 3);
            queue.add(last * 5);
            id++;
        }
        return (int) last;
    }
}
