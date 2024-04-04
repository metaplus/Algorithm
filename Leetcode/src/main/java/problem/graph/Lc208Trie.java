package problem.graph;

import java.util.Objects;
import java.util.TreeSet;

public class Lc208Trie {

    class Trie {


        TreeSet<String> set = new TreeSet<>();

        public Trie() {

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
