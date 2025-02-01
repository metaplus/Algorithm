package problem.dp.sequence;

import java.util.ArrayList;
import java.util.List;

public class Lc118Generate {


    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>(numRows);
        List<Integer> row = new ArrayList<>(2);
        for (int i = 0; i < numRows; i++) {
            List<Integer> next = new ArrayList<>(row.size() + 1);
            for (int j = 0; j < row.size(); j++) {
                next.add(row.get(j) + (j > 0 ? row.get(j - 1) : 0));
            }
            next.add(1);
            row = next;
            result.add(row);
        }
        return result;
    }
}
