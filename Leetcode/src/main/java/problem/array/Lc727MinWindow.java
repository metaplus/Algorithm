package problem.array;

public class Lc727MinWindow {

    public String minWindow(String s1, String s2) {
        if (s2.length() == 1) {
            return s1.contains(s2) ? s2 : "";
        }
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int left = 0;
        int lenMin = Integer.MAX_VALUE;
        int leftMin = 0;
        for (int i = 0; i < chars1.length; i++) {
            if (chars1[i] != chars2[chars2.length - 1]) {
                continue;
            }
            if (i - left + 1 < s2.length()) {
                continue;
            }
            for (int j = i - 1, k = chars2.length - 2; j >= left && k >= 0; j--) {
                if (chars1[j] == chars2[k]) {
                    if (k == 0) {
                        int len = i - j + 1;
                        if (len < lenMin) {
                            lenMin = len;
                            leftMin = j;
                        }
                        for (int l = j + 1; l < i; l++) {
                            if (chars1[l] == chars2[0]) {
                                left = l;
                                break;
                            }
                            if (l == i - 1) {
                                left = i;
                            }
                        }
                        break;
                    }
                    k--;
                }
            }
        }
        return lenMin < Integer.MAX_VALUE ? s1.substring(leftMin, leftMin + lenMin) : "";
    }
}
