package problem.search.bfs;

import java.util.ArrayDeque;
import java.util.Deque;

public class Lc433MinMutation {

    public int minMutation(String startGene, String endGene, String[] banks) {

        Deque<String> deque = new ArrayDeque<>();
        deque.add(startGene);
        int level = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            level++;
            while (size-- > 0) {
                String poll = deque.poll();
                for (int i = 0; i < banks.length; i++) {
                    if (banks[i] == null) {
                        continue;
                    }
                    if (isShift(poll, banks[i])) {
                        if (endGene.equals(banks[i])) {
                            return level;
                        }
                        deque.add(banks[i]);
                        banks[i] = null;
                    }
                }

            }
        }
        return -1;
    }

    private boolean isShift(String left, String right) {
        int count = 0;
        for (int i = 0; i < left.length(); i++) {
            if (left.charAt(i) != right.charAt(i)) {
                if (++count > 1) {
                    return false;
                }
            }
        }
        return count == 1;
    }
}
