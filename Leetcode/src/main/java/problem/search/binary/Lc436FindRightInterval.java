package problem.search.binary;

import java.util.Arrays;
import java.util.Comparator;

public class Lc436FindRightInterval {

    public int[] findRightInterval(int[][] intervals) {
        Cell[] cells = new Cell[intervals.length];
        Arrays.setAll(cells, i -> {
            Cell cell = new Cell();
            cell.val = intervals[i];
            cell.index = i;
            return cell;
        });
        Arrays.sort(cells, Comparator.comparingInt(a -> a.val[0]));
        int[] result = new int[intervals.length];
        for (int i = 0; i < cells.length; i++) {
            int left =0;
            int right = cells.length;
            while (left < right) {
                int mid = (left + right) / 2;
                if (cells[mid].val[0] < cells[i].val[1]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            result[cells[i].index] = left == cells.length ? -1 : cells[left].index;
        }
        return result;
    }

    public int[] findRightInterval2(int[][] intervals) {
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

        @Override
        public String toString() {
            return "Cell{" +
                    "val=" + Arrays.toString(val) +
                    ", index=" + index +
                    '}';
        }
    }
}
