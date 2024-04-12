package problem.deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class Lc71SimplifyPath {

    public String simplifyPath(String path) {
        Deque<String> deque = new ArrayDeque<>();
        int left = -1;
        while (left < path.length()) {
            int index = path.indexOf('/', left + 1);
            if (index < 0) {
                index = path.length();
            }
            if (left < 0) {
                left = index;
                continue;
            }
            if (left + 1 == index) {
                left = index;
                continue;
            }
            String dir = path.substring(left + 1, index);
            if ("..".equals(dir)) {
                if (!deque.isEmpty()) {
                    deque.pop();
                }
            } else if (!".".equals(dir)) {
                deque.push(dir);
            }
            left = index;
        }
        if (deque.isEmpty()) {
            return "/";
        }
        StringBuilder builder = new StringBuilder();
        while (!deque.isEmpty()) {
            builder.append('/').append(deque.pollLast());
        }
        return builder.toString();
    }
}
