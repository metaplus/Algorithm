package problem.array;

import java.util.Objects;

public class Lc676MagicDictionary {

    class MagicDictionary {

        private String[] dictionary;

        public MagicDictionary() {

        }

        public void buildDict(String[] dictionary) {
            this.dictionary = dictionary;
        }

        public boolean search(String searchWord) {
            if (Objects.isNull(searchWord) || searchWord.isEmpty()) {
                return false;
            }
            for (String s : dictionary) {
                if (s.length() != searchWord.length()) {
                    continue;
                }
                int diff = 0;
                for (int i = 0; i < s.length(); i++) {
                    diff += s.charAt(i) == searchWord.charAt(i) ? 0 : 1;
                    if (diff > 1) {
                        break;
                    }
                }
                if (diff == 1) {
                    return true;
                }
            }
            return false;
        }
    }
}
