package problem.deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class Lc933RecentCounter {

    class RecentCounter {

        Deque<Integer> deque = new ArrayDeque<>();

        public RecentCounter() {

        }

        public int ping(int t) {
            while (!deque.isEmpty() && deque.peekFirst() < t - 3000) {
                deque.pollFirst();
            }
            deque.add(t);
            return deque.size();
        }
    }

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
}
