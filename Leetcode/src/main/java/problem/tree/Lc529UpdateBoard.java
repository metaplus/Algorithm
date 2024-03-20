package problem.tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class Lc529UpdateBoard {

    private int[][] dirs = new int[][]{
            new int[]{-1, 1},
            new int[]{0, 1},
            new int[]{1, 1},
            new int[]{-1, 0},
            new int[]{1, 0},
            new int[]{-1, -1},
            new int[]{0, -1},
            new int[]{1, -1},
    };

    public char[][] updateBoard(char[][] board, int[] click) {
        if ('M' == board[click[0]][click[1]]) {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        if (board[click[0]][click[1]] >= '0' && board[click[0]][click[1]] <= '9') {
            return board;
        }
        int rows = board.length;
        int cols = board[0].length;
        int[][] counts = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] != 'M') {
                    continue;
                }
                for (int[] dir : dirs) {
                    int x = i + dir[0];
                    int y = j + dir[1];
                    if (x < 0 || y < 0 || x > rows - 1 || y > cols - 1) {
                        continue;
                    }
                    if (board[x][y] != 'M') {
                        counts[x][y]++;
                    }
                }
            }
        }
        return bfs(board, click, counts, rows, cols);
    }

    private char[][] bfs(char[][] board, int[] click, int[][] counts, int rows, int cols) {
        if (counts[click[0]][click[1]] == 0) {
            counts[click[0]][click[1]] = Integer.MIN_VALUE;
            board[click[0]][click[1]] = 'B';
        } else {
            board[click[0]][click[1]] = (char) ('0' + counts[click[0]][click[1]]);
            return board;
        }
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(click);
        counts[click[0]][click[1]] = -1;
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                int[] pos = deque.poll();
                for (int[] dir : dirs) {
                    int x = pos[0] + dir[0];
                    int y = pos[1] + dir[1];
                    if (x < 0 || y < 0 || x > rows - 1 || y > cols - 1) {
                        continue;
                    }
                    if (counts[x][y] < 0) {
                        continue;
                    }
                    if (board[x][y] == 'M') {
                        continue;
                    }
                    if (counts[x][y] == 0) {
                        counts[x][y] = Integer.MIN_VALUE;
                        board[x][y] = 'B';
                        deque.offer(new int[]{x, y});
                        continue;
                    }
                    board[x][y] = (char) ('0' + counts[x][y]);
                    counts[x][y] *= -1;
                }
            }
        }
        return board;
    }
}
