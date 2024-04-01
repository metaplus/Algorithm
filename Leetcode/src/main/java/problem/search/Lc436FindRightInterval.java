package problem.search;

import java.util.Arrays;

public class Lc436FindRightInterval {

    public int[] findRightInterval(int[][] intervals) {
        Cell[] cells = new Cell[intervals.length];
        Arrays.setAll(cells, i -> {
            Cell cell = new Cell();
            cell.val = intervals[i];
            cell.index = i;
            return cell;
        });
        Arrays.sort(cells, (a, b) -> {
            if (a.val[0] != b.val[0]) {
                return a.val[0] - b.val[0];
            }
            return a.index - b.index;
        });
        int[] res = new int[intervals.length];
        for (int i = 0; i < cells.length; i++) {
            if (cells[i].val[0] == cells[i].val[1]) {
                res[cells[i].index] = i;
                continue;
            }
            int j = i + 1;
            for (; j < cells.length; j++) {
                if (cells[j].val[0] >= cells[i].val[1]) {
                    break;
                }
            }
            if (j < cells.length) {
                res[cells[i].index] = cells[j].index;
                continue;
            }
            res[cells[i].index] = -1;
        }
        return res;
    }

    private class Cell {

        int[] val;
        int index;
    }
}
