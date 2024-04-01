package problem.dp;

import java.util.Objects;

public class Lc329LongestIncreasingPath {

    private static final int[][] DIRS = new int[][]{
            new int[]{-1, 0},
            new int[]{1, 0},
            new int[]{0, 1},
            new int[]{0, -1}};


    public int longestIncreasingPath(int[][] matrix) {
        Cell[][] cache = new Cell[matrix.length][matrix[0].length];
        Cell max = null;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                Cell cell = dfs(matrix, i, j, cache, -1);
                if (Objects.isNull(max) || cell.path > max.path) {
                    max = cell;
                }
            }
        }
        return max.path;
    }

    private Cell dfs(int[][] matrix, int i, int j, Cell[][] cache, int source) {
        if (i < 0 || j < 0 || i > matrix.length - 1 || j > matrix[0].length - 1) {
            return null;
        }
        if (matrix[i][j] < 0) {
            return null;
        }
        if (source >= matrix[i][j]) {
            return null;
        }
        if (Objects.nonNull(cache[i][j])) {
            return cache[i][j];
        }
        Cell node = new Cell(1, matrix[i][j]);
        Cell next = null;
        int source1 = matrix[i][j];
        matrix[i][j] = -1 - matrix[i][j];
        for (int[] dir : DIRS) {
            Cell cell = dfs(matrix, i + dir[0], j + dir[1], cache, source1);
            if (Objects.isNull(cell)) {
                continue;
            }
            if (Objects.isNull(next) || cell.path > next.path) {
                next = cell;
            }
        }
        matrix[i][j] = -1 - matrix[i][j];
        if (Objects.nonNull(next)) {
            node.path = next.path + 1;
            node.weight = next.weight + matrix[i][j];
        }
        cache[i][j] = node;
        return node;
    }

    private class Cell {

        int path;
        int weight;

        public Cell(int path, int weight) {
            this.path = path;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Cell{" +
                    "path=" + path +
                    ", weight=" + weight +
                    '}';
        }
    }
}
