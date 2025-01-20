package problem.array.simulate;

import java.util.ArrayDeque;
import java.util.Deque;

public class Lc3174ClearDigits {

    public String clearDigits(String s) {
        Deque<Integer> deque = new ArrayDeque<>(s.length() / 2);
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isDigit(chars[i])) {
                if (!deque.isEmpty()) {
                    chars[deque.pollLast()] = 0;
                }
                chars[i] = 0;
                continue;
            }
            deque.add(i);
        }
        StringBuilder builder = new StringBuilder();
        for (char c : chars) {
            if (c > 0) {
                builder.append(c);
            }
        }
        return builder.toString();
    }
}
