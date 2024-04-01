package problem.array.parse;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.collections.impl.list.mutable.FastList;

import java.util.ArrayList;
import java.util.List;

public abstract class ArrayParse {

    public static int[][] parse2DIntArray(String s) {
        s = StringUtils.deleteWhitespace(s);
        String s1 = StringUtils.substringBetween(s, "[[", "]]");
        String[] tokens = StringUtils.splitByWholeSeparatorPreserveAllTokens(s1, "],[");
        int[][] array = new int[tokens.length][];
        for (int i = 0; i < tokens.length; i++) {
            String[] cols = StringUtils.split(tokens[i], ',');
            array[i] = new int[cols.length];
            for (int j = 0; j < cols.length; j++) {
                array[i][j] = Integer.parseInt(cols[j]);
            }
        }
        return array;
    }

    public static List<List<Integer>> parse2DIntList(String s) {
        s = StringUtils.deleteWhitespace(s);
        String s1 = StringUtils.substringBetween(s, "[[", "]]");
        String[] tokens = StringUtils.splitByWholeSeparatorPreserveAllTokens(s1, "],[");
        List<List<Integer>> result = new ArrayList<>(tokens.length);
        for (String token : tokens) {
            String[] cols = StringUtils.split(token, ',');
            List<Integer> row = new ArrayList<>(cols.length);
            for (String col : cols) {
                row.add(Integer.parseInt(col));
            }
            result.add(row);
        }
        return result;
    }

    public static int[] parseIntArray(String s) {
        s = StringUtils.deleteWhitespace(s);
        String s1 = StringUtils.substringBetween(s, "[", "]");
        if (StringUtils.isBlank(s1)) {
            return new int[0];
        }
        return FastList.newListWith(StringUtils.split(s1, ','))
                .collectInt(text -> Integer.parseInt(StringUtils.strip(text)))
                .toArray();
    }

    public static List<Integer> parseIntList(String s) {
        s = StringUtils.deleteWhitespace(s);
        String s1 = StringUtils.substringBetween(s, "[", "]");
        if (StringUtils.isBlank(s1)) {
            return FastList.newList();
        }
        return FastList.newListWith(StringUtils.split(s1, ','))
                .collect(text -> "null".equals(text) ? null : Integer.parseInt(StringUtils.strip(text)));
    }

    public static List<String> parseStringList(String s) {
        s = StringUtils.deleteWhitespace(s);
        String s1 = StringUtils.substringBetween(s, "[", "]");
        if (StringUtils.isBlank(s1)) {
            return FastList.newList();
        }
        return FastList.newListWith(StringUtils.splitByWholeSeparatorPreserveAllTokens(StringUtils.strip(s1, "\""), "\",\""));
    }

    public static Integer[] parseIntegerArray(String s) {
        s = StringUtils.deleteWhitespace(s);
        String s1 = StringUtils.substringBetween(s, "[", "]");
        if (StringUtils.isBlank(s1)) {
            return new Integer[0];
        }
        return FastList.newListWith(StringUtils.split(s1, ','))
                .collect(text -> "null".equals(text) ? null : Integer.parseInt(StringUtils.strip(text)))
                .toArray(new Integer[0]);
    }

    public static double[] parseDoubleArray(String s) {
        s = StringUtils.deleteWhitespace(s);
        String s1 = StringUtils.substringBetween(s, "[", "]");
        if (StringUtils.isBlank(s1)) {
            return new double[0];
        }
        return FastList.newListWith(StringUtils.split(s1, ','))
                .collectDouble(text -> Double.parseDouble(StringUtils.strip(text)))
                .toArray();
    }

    public static String[][] parse2DStringArray(String s) {
        s = StringUtils.deleteWhitespace(s);
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
        s = StringUtils.deleteWhitespace(s);
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
