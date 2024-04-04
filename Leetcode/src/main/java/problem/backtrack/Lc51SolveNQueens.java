package problem.backtrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lc51SolveNQueens {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        dfs(n, 0, new Cell[n], new ArrayList<>(n), result);
        return result;
    }

    private void dfs(int n, int i, Cell[] cells, List<Integer> path, List<List<String>> result) {
        if (i >= n) {
            List<String> list = new ArrayList<>(n);
            StringBuilder builder = new StringBuilder();
            for (Integer col : path) {
                builder.setLength(0);
                for (int k = 0; k < n; k++) {
                    if (k == col) {
                        builder.append('Q');
                        continue;
                    }
                    builder.append('.');
                }
                list.add(builder.toString());
            }
            result.add(list);
            return;
        }
        for (int j = 0; j < cells.length; j++) {
            if (Objects.nonNull(cells[j])) {
                continue;
            }
            boolean accept = true;
            for (Cell cell : cells) {
                if (Objects.isNull(cell)) {
                    continue;
                }
                if (i - cell.x == Math.abs(j - cell.y)) {
                    accept = false;
                    break;
                }
            }
            if (!accept) {
                continue;
            }
            cells[j] = new Cell(i, j);
            path.add(j);
            dfs(n, i + 1, cells, path, result);
            cells[j] = null;
            path.remove(path.size() - 1);
        }
    }

    private static class Cell {

        private int x;
        private int y;

        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
