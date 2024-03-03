package problem.dp;

import java.util.*;

public class Lc120MinimumTotal {

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }
        List<Integer> paths = null;
        int total = Integer.MAX_VALUE;
        for (int i = 0; i < triangle.size(); i++) {
            List<Integer> row = triangle.get(i);
            if (i == 0) {
                paths = row;
                continue;
            }
            List<Integer> rowNext = new ArrayList<>(row.size());
            for (int j = 0; j < row.size(); j++) {
                Integer col = j < paths.size() ? paths.get(j) : null;
                if (j > 0 && j - 1 < paths.size()) {
                    if (Objects.isNull(col)) {
                        col = paths.get(j - 1);
                    } else {
                        col = Math.min(col, paths.get(j - 1));
                    }
                }
                int total1 = col + row.get(j);
                rowNext.add(j, total1);
                if (i == triangle.size() - 1 && (total1 < total)) {
                    total = total1;
                }
            }
            paths = rowNext;
        }
        return total;
    }
}
