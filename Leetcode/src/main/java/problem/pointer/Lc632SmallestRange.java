package problem.pointer;

import java.util.*;

public class Lc632SmallestRange {
    public int[] smallestRange(List<List<Integer>> nums) {
        int size = 0;
        for (List<Integer> num : nums) {
            size += num.size();
        }
        Cell[] cells = new Cell[size];
        int id = 0;
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> list = nums.get(i);
            for (int j = 0; j < list.size(); j++) {
                cells[id++] = new Cell(list.get(j), j, i);
            }
        }
        Arrays.sort(cells, (a, b) -> {
            if (a.val != b.val) {
                return a.val - b.val;
            }
            if (a.index != b.index) {
                return a.index - b.index;
            }
            return a.row - b.row;
        });
        Map<Integer, Integer> count = new HashMap<>();
        Cell[] countMin = new Cell[2];
        int lenMin = Integer.MAX_VALUE;
        int left = 0;
        for (int i = 0; i < cells.length; i++) {
            count.merge(cells[i].row, 1, Integer::sum);
            if (count.size() < nums.size()) {
                continue;
            }
            int len = cells[i].val - cells[left].val;
            if (len < lenMin) {
                countMin[0] = cells[left];
                countMin[1] = cells[i];
                lenMin = len;
            }
            while (count.size() >= nums.size()) {
                if (count.merge(cells[left].row, -1, Integer::sum) == 0) {
                    count.remove(cells[left].row);
                }
                left++;
                if (count.size() >= nums.size()) {
                    len = cells[i].val - cells[left].val;
                    if (len < lenMin) {
                        countMin[0] = cells[left];
                        countMin[1] = cells[i];
                        lenMin = len;
                    }
                }
            }
        }
        if (Objects.isNull(countMin[0])) {
            return new int[0];
        }
        return new int[]{countMin[0].val, countMin[1].val};
    }

    private class Cell {

        int val;
        int index;
        int row;

        public Cell(int val, int index, int row) {
            this.val = val;
            this.index = index;
            this.row = row;
        }

        @Override
        public String toString() {
            return "Cell{" +
                    "val=" + val +
                    ", index=" + index +
                    ", row=" + row +
                    '}';
        }
    }
}
