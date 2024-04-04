package problem.backtrack;

import java.util.Objects;

public class Lc52TotalNQueens {

    public int totalNQueens(int n) {
        return dfs(n, new Cell[n], 0);
    }

    private int dfs(int n, Cell[] cells, int i) {
        int sum = 0;
        for (int j = 0; j < n; j++) {
            if (!accept(i, j, cells)) {
                continue;
            }
            if (i == n - 1) {
                sum++;
                continue;
            }
            cells[i] = new Cell(i, j);
            sum += dfs(n, cells, i + 1);
            cells[i] = null;
        }
        return sum;
    }

    private boolean accept(int i, int j, Cell[] cells) {
        for (Cell cell : cells) {
            if (Objects.isNull(cell)) {
                continue;
            }
            if (cell.j == j) {
                return false;
            }
            if (j < cell.j) {
                if (i - cell.i == cell.j - j) {
                    return false;
                }
                continue;
            }
            if (i - cell.i == j - cell.j) {
                return false;
            }
        }
        return true;
    }

    private class Cell {

        private int i;
        private int j;

        public Cell(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
