package problem.deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class Lc316RemoveDuplicateLetters {

    public String removeDuplicateLetters(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        int[] counts = new int[26];
        int[] remains = new int[26];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            remains[c - 'a']++;
        }
        for (int i = 0; i < chars.length; i++) {
            remains[chars[i] - 'a']--;
            if (counts[chars[i] - 'a'] == 1) {
                continue;
            }
            counts[chars[i] - 'a']++;
            while (!deque.isEmpty()
                    && deque.peekLast() > chars[i]
                    && remains[deque.peekLast() - 'a'] > 0) {
                counts[deque.peekLast() - 'a']--;
                deque.pollLast();
            }
            if (counts[chars[i] - 'a'] == 1) {
                deque.add(chars[i]);
            }
        }
        StringBuilder builder = new StringBuilder(deque.size());
        for (Character c : deque) {
            builder.append(c);
        }
        return builder.toString();
    }
}
