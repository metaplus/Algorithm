package problem.array;

public class Lc14LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
//        if (strs.length < 2) {
//            return "";
//        }
        for (int i = 0; i < strs[0].length(); i++) {
            char c = 0;
            for (String str : strs) {
                if (i >= str.length()) {
                    return str.substring(0, i);
                }
                if (c == 0) {
                    c = str.charAt(i);
                    continue;
                }
                if (c != str.charAt(i)) {
                    return str.substring(0, i);
                }
            }
        }
        return strs[0];
    }

}
