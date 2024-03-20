package problem.array.parse;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.collections.impl.list.mutable.FastList;

public abstract class ArrayParse {

    public static int[][] parse2DIntArray(String s) {
        String s1 = StringUtils.substringBetween(s, "[[", "]]");
        String[] tokens = StringUtils.splitByWholeSeparator(s1, "],[");
        int[][] array = new int[tokens.length][StringUtils.countMatches(tokens[0], ',') + 1];
        for (int i = 0; i < tokens.length; i++) {
            String[] cols = StringUtils.split(tokens[i], ',');
            for (int j = 0; j < cols.length; j++) {
                array[i][j] = Integer.parseInt(cols[j]);
            }
        }
        return array;
    }

    public static int[] parseIntArray(String s) {
        String s1 = StringUtils.substringBetween(s, "[", "]");
        if (StringUtils.isBlank(s1)) {
            return new int[0];
        }
        return FastList.newListWith(StringUtils.split(s1, ','))
                .collectInt(Integer::parseInt)
                .toArray();
    }

    public static String[][] parse2DStringArray(String s) {
        String s1 = StringUtils.substringBetween(s, "[[", "]]");
        String[] tokens = StringUtils.splitByWholeSeparator(s1, "],[");
        String[][] array = new String[tokens.length][StringUtils.countMatches(tokens[0], ',') + 1];
        for (int i = 0; i < tokens.length; i++) {
            String[] cols = StringUtils.split(tokens[i], ',');
            for (int j = 0; j < cols.length; j++) {
                array[i][j] = StringUtils.strip(cols[j], "\"");
            }
        }
        return array;
    }

    public static char[][] parse2DCharArray(String s) {
        String s1 = StringUtils.substringBetween(s, "[[", "]]");
        String[] tokens = StringUtils.splitByWholeSeparator(s1, "],[");
        char[][] array = new char[tokens.length][StringUtils.countMatches(tokens[0], ',') + 1];
        for (int i = 0; i < tokens.length; i++) {
            String[] cols = StringUtils.split(tokens[i], ',');
            for (int j = 0; j < cols.length; j++) {
                array[i][j] = StringUtils.strip(cols[j], "\"").charAt(0);
            }
        }
        return array;
    }
}
