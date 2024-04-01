package problem.array;

import java.util.ArrayDeque;
import java.util.Deque;

public class Lc20IsValid {

    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : chars) {
            switch (c) {
                case '(': {
                    deque.offer(c);
                    break;
                }
                case ')': {
                    if (deque.isEmpty() || deque.pollLast() != '(') {
                        return false;
                    }
                    break;
                }
                case '[': {
                    deque.offer(c);
                    break;
                }
                case ']': {
                    if (deque.isEmpty() || deque.pollLast() != '[') {
                        return false;
                    }
                    break;
                }
                case '{': {
                    deque.offer(c);
                    break;
                }
                case '}': {
                    if (deque.isEmpty() || deque.pollLast() != '{') {
                        return false;
                    }
                    break;
                }
            }
        }
        return deque.isEmpty();
    }
}
