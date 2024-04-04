package problem.deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class Lc739DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!deque.isEmpty() && temperatures[deque.peek()] < temperatures[i]) {
                result[deque.peek()] = i - deque.peek();
                deque.pop();
            }
            deque.push(i);
        }
        return result;
    }
}
