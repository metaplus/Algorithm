package problem.deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class Lc224Calculate {

    public int calculate(String s) {
        char[] chars = s.toCharArray();
        int digit = 0;
        Deque<Cell> deque = new ArrayDeque<>();
        deque.add(new Cell());
        for (int i = 0; i < chars.length; i++) {
            if (Character.isWhitespace(chars[i])) {
                continue;
            }
            switch (chars[i]) {
                case '(': {
                    deque.push(new Cell());
                    break;
                }
                case ')': {
                    Cell cell = deque.pop();
                    deque.peek().digits.push(cell.compute());
                    break;
                }
                case '+':
                case '-': {
                    if (deque.peek().digits.isEmpty()) {
                        deque.peek().digits.offer(0);
                    }
                    deque.peek().operators.push(chars[i]);
                    break;
                }
                default: {
                    if (i > 0 && Character.isDigit(chars[i - 1])) {
                        Integer d = deque.peek().digits.pop();
                        d = d * 10 + (chars[i] - '0');
                        deque.peek().digits.push(d);
                    } else {
                        deque.peek().digits.push(chars[i] - '0');
                    }
                }
            }
        }
        if (!deque.peek().operators.isEmpty()) {
            return deque.peek().compute();
        }
        return deque.peek().digits.peek();
    }

    private static class Cell {

        Deque<Integer> digits = new ArrayDeque<>(4);
        Deque<Character> operators = new ArrayDeque<>(4);

        int compute() {
            while (!operators.isEmpty()) {
                switch (operators.pollLast()) {
                    case '+': {
                        digits.addLast(digits.pollLast() + digits.pollLast());
                        break;
                    }
                    case '-': {
                        digits.addLast(digits.pollLast() - digits.pollLast());
                        break;
                    }
                }
            }
            return digits.peek();
        }

        @Override
        public String toString() {
            return "Cell{" +
                    "digits=" + digits +
                    ", operators=" + operators +
                    '}';
        }
    }
}
