package util;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class Translate {

    private static final Pattern gridPattern = Pattern.compile("\\[\\S+]");

    public static int[][] grid(String input) {
        Matcher matcher = gridPattern.matcher(input);
        List<IntStream> groupList = new ArrayList<>();
        while (matcher.find()) {
            groupList.add(Arrays
                    .stream(matcher.group().split("[,\\[\\]]"))
                    .filter(str -> Objects.nonNull(str) && !str.isEmpty())
                    .mapToInt(Integer::valueOf));
        }
        int grid[][] = new int[groupList.size()][];
        ListIterator<IntStream> iterator = groupList.listIterator();
        while (iterator.hasNext()) {
            grid[iterator.nextIndex()] = iterator.next().toArray();
        }
        return grid;
    }
}
