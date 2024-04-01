package problem.tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class Lc909SnakesAndLadders {

    private int snakeX(int id, int rows, int cols) {
        id = (id - 1) / cols;
        return rows - 1 - id;
    }

    private int snakeY(int id, int cols) {
        int mod = (id - 1) % cols;
        id = (id - 1) / cols;
        if (id % 2 == 0) {
            return mod;
        }
        return cols - 1 - mod;
    }

    public int snakesAndLadders(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        int mul = rows * cols;
        Deque<Cell> deque = new ArrayDeque<>();
        deque.offer(new Cell(1, snakeX(1, rows, cols), snakeY(1, cols)));
        int level = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            level++;
            while (size-- > 0) {
                Cell cell = deque.poll();
                int id = Integer.MAX_VALUE;
                int x = 0;
                int y = 0;
                for (int i = 1; i <= 6; i++) {
                    int idNext = cell.id + i;
                    if (idNext >= mul) {
                        return level;
                    }
                    int xNest = snakeX(idNext, rows, cols);
                    int yNest = snakeY(idNext, cols);
                    if (Math.abs(board[xNest][yNest]) > 1) {
                        if (board[xNest][yNest] < 0) {
                            continue;
                        }
                        if (board[xNest][yNest] >= mul) {
                            return level;
                        }
                        deque.offer(new Cell(board[xNest][yNest],
                                snakeX(board[xNest][yNest], rows, cols),
                                snakeY(board[xNest][yNest], cols)));
                        board[xNest][yNest] *= -1;
                        continue;
                    }
                    if (board[xNest][yNest] == -1) {
                        id = idNext;
                        x = xNest;
                        y = yNest;
                    }
                }
                if (id < Integer.MAX_VALUE) {
                    deque.offer(new Cell(id, x, y));
                }
            }
        }
        return -1;
    }

    class Cell {

        int id;
        int row;
        int col;

        public Cell(int id, int row, int col) {
            this.id = id;
            this.row = row;
            this.col = col;
        }

        @Override
        public String toString() {
            return "Cell{" +
                    "id=" + id +
                    ", row=" + row +
                    ", col=" + col +
                    '}';
        }
    }
}
