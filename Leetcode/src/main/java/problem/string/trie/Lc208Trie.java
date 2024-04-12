package problem.string.trie;

import java.util.Objects;
import java.util.TreeSet;

public class Lc208Trie {

    class Trie {

        Trie[] tries = new Trie[26];
        boolean last = false;

        public Trie() {

        }

        public void insert(String word) {
            insert(word, 0);
        }

        private void insert(String word, int i) {
            if (i == word.length()) {
                last = true;
                return;
            }
            char c = word.charAt(i);
            if (Objects.isNull(tries[c - 'a'])) {
                tries[c - 'a'] = new Trie();
            }
            tries[c - 'a'].insert(word, i + 1);
        }


        public boolean search(String word) {
            return search(word, 0);
        }

        public boolean search(String word, int i) {
            if (i == word.length()) {
                return last;
            }
            char c = word.charAt(i);
            if (Objects.isNull(tries[c - 'a'])) {
                return false;
            }
            return tries[c - 'a'].search(word, i + 1);
        }

        public boolean startsWith(String prefix) {
            return startsWith(prefix, 0);
        }

        public boolean startsWith(String prefix, int i) {
            if (i == prefix.length()) {
                return true;
            }
            char c = prefix.charAt(i);
            if (Objects.isNull(tries[c - 'a'])) {
                return false;
            }
            return tries[c - 'a'].startsWith(prefix, i + 1);
        }

    }

    class Trie2 {


        TreeSet<String> set = new TreeSet<>();

        public Trie2() {

        }

        public void insert(String word) {
            set.add(word);
        }

        public boolean search(String word) {
            String floor = set.ceiling(word);
            return word.equals(floor);
        }

        public boolean startsWith(String prefix) {
            String floor = set.ceiling(prefix);
            return Objects.nonNull(floor) && floor.startsWith(prefix);
        }
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
}
