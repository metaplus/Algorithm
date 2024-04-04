package problem.deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class Lc155MinStack {

    class MinStack {

        private final Deque<Integer> dataDeque = new ArrayDeque<>();
        private final Deque<Integer> minDeque = new ArrayDeque<>();

        public MinStack() {

        }

        public void push(int val) {
            dataDeque.addFirst(val);
            minDeque.addFirst(minDeque.isEmpty() ? val : Math.min(val, minDeque.peekFirst()));
        }

        public void pop() {
            if (dataDeque.isEmpty()) {
                return;
            }
            dataDeque.removeFirst();
            minDeque.removeFirst();
        }

        public int top() {
            if (dataDeque.isEmpty()) {
                return -1;
            }
            return dataDeque.peekFirst();
        }

        public int getMin() {
            if (dataDeque.isEmpty()) {
                return -1;
            }
            return minDeque.peekFirst();
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
}
