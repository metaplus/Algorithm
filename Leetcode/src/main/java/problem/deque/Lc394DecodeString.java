package problem.deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class Lc394DecodeString {

    public String decodeString(String s) {
        return dfs(s.toCharArray(), 0, s.length() - 1).toString();
    }

    private StringBuilder dfs(char[] chars, int left, int right) {
        if (left > right) {
            return new StringBuilder(2);
        }
        if (Character.isLetter(chars[left])) {
            StringBuilder builder = new StringBuilder(8);
            while (left <= right && Character.isLetter(chars[left])) {
                builder.append(chars[left++]);
            }
            builder.append(dfs(chars, left, right));
            return builder;
        }
        int num = 0;
        while (Character.isDigit(chars[left])) {
            num *= 10;
            num += chars[left++] - '0';
        }
        int bracket = 0;
        StringBuilder builder = new StringBuilder(32);
        for (int i = left; i <= right; i++) {
            if (chars[i] == '[') {
                bracket++;
                continue;
            }
            if (chars[i] == ']') {
                if (--bracket == 0) {
                    StringBuilder element = dfs(chars, left + 1, i - 1);
                    for (int j = 0; j < num; j++) {
                        builder.append(element);
                    }
                    builder.append(dfs(chars, i + 1, right));
                    break;
                }
            }
        }
        return builder;
    }

    public String decodeString3(String s) {
        StringBuilder builder = dfs3(s.toCharArray(), 0, s.length());
        return builder.toString();
    }

    private StringBuilder dfs3(char[] chars, int index, int end) {
        if (index == end) {
            return new StringBuilder(2);
        }
        int num = 0;
        int left = index;
        while (Character.isDigit(chars[left])) {
            num *= 10;
            num += (chars[left] - '0');
            left++;
        }
        StringBuilder builder = new StringBuilder(end - index);
        if (chars[left] == '[') {
            int bracket = 1;
            for (int i = left + 1; i < end; i++) {
                if (chars[i] == '[') {
                    bracket++;
                    continue;
                }
                if (chars[i] == ']') {
                    if (--bracket == 0) {
                        StringBuilder next1 = dfs3(chars, left + 1, i);
                        for (int j = 0; j < num; j++) {
                            builder.append(next1);
                        }
                        builder.append(dfs3(chars, i + 1, end));
                        break;
                    }
                }
            }
            return builder;
        }
        while (left < end && Character.isLetter(chars[left])) {
            builder.append(chars[left]);
            left++;
        }
        builder.append(dfs3(chars, left, end));
        return builder;
    }

    public String decodeString2(String s) {
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
