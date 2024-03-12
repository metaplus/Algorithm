package problem.hashmap;

public class Lc424CharacterReplacement {


    public int characterReplacement(String s, int k) {
        int[] counts = new int[26];
        int left = 0;
        int lenMax = 0;
        char[] chars = s.toCharArray();
        char charMax = 0;
        int countMax = 0;
        for (int i = 0; i < chars.length; i++) {
//            int count = counts.compute(chars[i], (key, c) -> Objects.isNull(c) ? 1 : c + 1);
            int count = ++counts[chars[i] - 'A'];
            int len = i - left + 1;
            if (count > countMax) {
                charMax = chars[i];
                countMax = count;
            }
            if (len - countMax <= k) {
                lenMax = Math.max(lenMax, len);
                continue;
            }
//            int countLeft = counts.compute(chars[left], (key, c) -> c - 1);
            int countLeft = --counts[chars[left] - 'A'];
            if (chars[left] == charMax) {
                for (int j = left + 1; j < i; j++) {
//                    int countJ = counts.get(chars[j]);
                    int countJ = counts[chars[j] - 'A'];
                    if (chars[j] != charMax
                            && countJ > countLeft) {
                        charMax = chars[j];
                        countMax = countJ;
                    }
                }
            }
            left++;
        }
        return lenMax;
    }


    public int characterReplacement2(String s, int k) {
        int width = 1;
        int[] count = new int['Z' - 'A' + 1];
        count[s.charAt(0) - 'A'] = 1;
        int left = 0;
        int countMax = 1;
        for (int i = 1; i < s.length(); i++) {
            int countRight = ++count[s.charAt(i) - 'A'];
            countMax = Math.max(countRight, countMax);
            if (i - left + 1 > countMax + k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }
            width = Math.max(width, i - left + 1);
        }
        return width;
    }
}
