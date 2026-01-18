package problem.dp;

import java.util.ArrayDeque;
import java.util.Deque;

public class Lc3542MinOperations {

    public int minOperations(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        int sum = 0;
        for (int num : nums) {
            if (num == 0) {
                sum += stack.size();
                stack.clear();
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > num) {
                stack.pop();
                sum++;
            }
            if (stack.isEmpty()
                    || stack.peek() != num) {
                stack.push(num);
            }
        }
        sum += stack.size();
        return sum;
    }
}
