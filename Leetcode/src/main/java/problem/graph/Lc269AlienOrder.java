package problem.graph;

import java.util.*;

public class Lc269AlienOrder {

    public String alienOrder(String[] words) {
        Set<Character>[] graph = new Set[26];
        Arrays.setAll(graph, i -> new HashSet<>(8));
        int[] in = new int[26];
        Set<Integer> set = new HashSet<>(26);
        Set<Character> tail = new HashSet<>(8);
        for (int i = 1; i < words.length; i++) {
            int size = Math.min(words[i].length(), words[i - 1].length());
            for (int j = 0; j < size; j++) {
                char left = words[i - 1].charAt(j);
                char right = words[i].charAt(j);
                set.add(left - 'a');
                set.add(right - 'a');
                if (left != right) {
                    if (graph[left - 'a'].add(right)) {
                        in[right - 'a']++;
                    }
                    break;
                }
                if (j == size - 1 && words[i - 1].length() > size) {
                    return "";
                }
            }
        }
        for (String word : words) {
            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                if (!set.contains(c - 'a')) {
                    tail.add(c);
                }
            }
        }
        Deque<Integer> deque = new ArrayDeque<>(26);
        for (int i = 0; i < in.length; i++) {
            if (in[i] == 0 && set.contains(i)) {
                deque.offerLast(i);
            }
        }
        StringBuilder builder = new StringBuilder();
        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size-- > 0) {
                Integer id = deque.pollFirst();
                builder.append((char) ('a' + id));
                in[id] = -1;
                for (Character next : graph[id]) {
                    if (--in[next - 'a'] == 0) {
                        deque.offerLast(next - 'a');
                    }
                }
            }
        }
//        for (int i = 0; i < in.length; i++) {
//            if (in[i] > 0) {
//                builder.append((char) ('a' + i));
//            }
//        }
        for (int i : in) {
            if (i > 0) {
                return "";
            }
        }
        for (Character c : tail) {
            builder.append(c);
        }
        return builder.toString();
    }
}
