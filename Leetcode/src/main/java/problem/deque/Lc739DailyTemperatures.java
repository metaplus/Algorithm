package problem.deque;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Lc739DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        List<Integer> stack = new ArrayList<>();
        int[] result = new int[temperatures.length];
        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[stack.get(stack.size() - 1)] <= temperatures[i]) {
                stack.remove(stack.size() - 1);
            }
            result[i] = stack.isEmpty() ? 0 : stack.get(stack.size() - 1) - i;
            stack.add(i);
        }
        return result;
    }

    public int[] dailyTemperatures3(int[] temperatures) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[temperatures.length];
        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!deque.isEmpty() && temperatures[deque.peek()] <= temperatures[i]) {
                deque.pop();
            }
            result[i] = deque.isEmpty() ? 0 : deque.peek() - i;
            deque.push(i);
        }
        return result;
    }

    public int[] dailyTemperatures2(int[] temperatures) {
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
