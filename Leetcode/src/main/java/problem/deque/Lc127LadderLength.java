package problem.deque;

import java.util.*;

public class Lc127LadderLength {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!beginWord.equals(wordList.get(0))) {
            wordList.add(wordList.get(0));
            wordList.set(0, beginWord);
        }
        List<Integer>[] map = new List[wordList.size()];
        Arrays.setAll(map, i -> new ArrayList<>(4));
        for (int i = 0; i < wordList.size(); i++) {
            for (int j = i + 1; j < wordList.size(); j++) {
                if (isShift(wordList.get(i), wordList.get(j))) {
                    map[i].add(j);
                    map[j].add(i);
                }
            }
        }
        Deque<Cell> deque = new ArrayDeque<>();
        deque.offer(new Cell(beginWord, 0, 1));
        boolean[] visit = new boolean[wordList.size()];
        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size-- > 0) {
                Cell cell = deque.poll();
                if (cell.index >= 0) {
                    visit[cell.index] = true;
                }
                List<Integer> adj = map[cell.index];
                if (Objects.isNull(adj)) {
                    continue;
                }
                for (Integer next : adj) {
                    if (!visit[next]) {
                        if (wordList.get(next).equals(endWord)) {
                            return cell.len + 1;
                        }
                        deque.offer(new Cell(wordList.get(next), next, cell.len + 1));
                    }
                }
            }
        }
        return 0;
    }

    private boolean isShift(String l, String r) {
        int diff = 0;
        for (int i = 0; i < l.length(); i++) {
            if (l.charAt(i) != r.charAt(i)) {
                if (++diff > 1) {
                    return false;
                }
            }
        }
        return diff == 1;
    }

    private class Cell {
        String word;
        int index;
        int len;

        public Cell(String word, int index, int len) {
            this.word = word;
            this.index = index;
            this.len = len;
        }

        @Override
        public String toString() {
            return "Cell{" +
                    "word='" + word + '\'' +
                    ", index=" + index +
                    ", len=" + len +
                    '}';
        }
    }
}
