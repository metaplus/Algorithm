package problem.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc118Generate {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>(numRows);
        res.add(Arrays.asList(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>(numRows + 1);
            for (int j = 0; j < i + 1; j++) {
                int val = 0;
                if (j < i) {
                    val += res.get(i - 1).get(j);
                }
                if (j > 0) {
                    val += res.get(i - 1).get(j - 1);
                }
                row.add(val);
            }
            res.add(row);
        }
        return res;
    }
}
