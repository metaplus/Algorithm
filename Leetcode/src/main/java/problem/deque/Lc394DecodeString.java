package problem.deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class Lc394DecodeString {

    public String decodeString(String s) {
        char[] chars = s.toCharArray();
        Deque<Cell> deque = new ArrayDeque<>(8);
        deque.offer(new Cell());
        int digit = -1;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                if (digit < 0) {
                    digit = chars[i] - '0';
                    if (deque.peekLast().alpha >= 0) {
                        for (int j = deque.peekLast().alpha; j < i; j++) {
                            deque.peekLast().builder.append(chars[j]);
                        }
                        deque.peekLast().alpha = -1;
                    }
                } else {
                    digit *= 10;
                    digit += chars[i] - '0';
                }
            }
            if (chars[i] >= 'a' && chars[i] <= 'z') {
                if (deque.peekLast().alpha < 0) {
                    deque.peekLast().alpha = i;
                }
            }
            if (chars[i] == '[') {
                Cell cell = new Cell();
                cell.digit = digit;
                digit = -1;
                deque.offer(cell);
            }
            if (chars[i] == ']') {
                if (deque.peekLast().alpha >= 0) {
                    for (int j = deque.peekLast().alpha; j < i; j++) {
                        deque.peekLast().builder.append(chars[j]);
                    }
                }
                Cell last = deque.pollLast();
                for (int k = 0; k < last.digit; k++) {
                    deque.peekLast().builder.append(last.builder);
                }
                deque.peekLast().alpha = -1;
            }
        }
        if (deque.peekLast().alpha >= 0) {
            for (int j = deque.peekLast().alpha; j < chars.length; j++) {
                deque.peekLast().builder.append(chars[j]);
            }
        }
        return deque.peekLast().builder.toString();
    }

    private class Cell {

        int digit = -1;
        int alpha = -1;
        StringBuilder builder = new StringBuilder();
    }
}
