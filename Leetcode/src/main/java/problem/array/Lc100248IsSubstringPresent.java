package problem.array;

import java.util.HashSet;
import java.util.Set;

public class Lc100248IsSubstringPresent {

    public boolean isSubstringPresent(String s) {
        char[] chars = s.toCharArray();
        if (chars.length < 2) {
            return false;
        }
        if (chars.length < 3) {
            return chars[0] == chars[1];
        }
        Set<Pair> set = new HashSet<>();
        for (int i = 1; i < chars.length; i++) {
            set.add(new Pair(chars[i], chars[i - 1]));
            if (set.contains(new Pair(chars[i - 1], chars[i]))) {
                return true;
            }
        }
        for (int i = 1; i < chars.length; i++) {
            if (set.contains(new Pair(chars[i - 1], chars[i]))) {
                return true;
            }
        }
        return false;
    }

    static class Pair {

        char a;
        char b;

        public Pair(char a, char b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            if (a != pair.a) return false;
            return b == pair.b;
        }

        @Override
        public int hashCode() {
            int result = a;
            result = 31 * result + (int) b;
            return result;
        }
    }
}
