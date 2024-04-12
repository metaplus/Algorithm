package problem.string.trie;

import java.util.Objects;

public class Lc211WordDictionary {
    public static class WordDictionary {

        WordDictionary[] trie = new WordDictionary[26];
        boolean last;

        public WordDictionary() {

        }

        public void addWord(String word) {
            dfsAdd(word, 0);
        }

        public void dfsAdd(String word, int i) {
            if (i == word.length()) {
                last = true;
                return;
            }
            int c = word.charAt(i) - 'a';
            if (Objects.isNull(trie[c])) {
                trie[c] = new WordDictionary();
            }
            trie[c].dfsAdd(word, i + 1);
        }

        public boolean search(String word) {
            return dfsSearch(word, 0);
        }

        public boolean dfsSearch(String word, int i) {
            if (i == word.length()) {
                return last;
            }
            int c = word.charAt(i) - 'a';
            if ('.' - 'a' != c) {
                if (Objects.isNull(trie[c])) {
                    return false;
                }
                return trie[c].dfsSearch(word, i + 1);
            }
            for (WordDictionary dictionary : trie) {
                if (Objects.nonNull(dictionary)
                        && dictionary.dfsSearch(word, i + 1)) {
                    return true;
                }
            }
            return false;
        }
    }

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
}
