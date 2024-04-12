package problem.hashmap;

public class Lc242IsAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            if (counts[t.charAt(i) - 'a']-- == 0) {
                return false;
            }
        }
        return true;
    }
}
