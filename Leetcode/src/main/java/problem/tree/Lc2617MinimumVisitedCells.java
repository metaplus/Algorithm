package problem.tree;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;

public class Lc2617MinimumVisitedCells {

    private int minimumVisitedCells2(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        if (grid[0][0] == 0) {
            return rows == 1 && cols == 1 ? 1 : -1;
        }
        int level = 0;
        Deque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{0, 0});
        grid[0][0] *= -1;
        while (!deque.isEmpty()) {
            int size = deque.size();
            level++;
            for (int i = 0; i < size; i++) {
                int[] pos = deque.poll();
                int xMax = pos[0] + Math.abs(grid[pos[0]][pos[1]]);
                int x = pos[0] + 1;
                while (x <= xMax && x < rows) {
                    if (x == rows - 1 && pos[1] == cols - 1) {
                        return level + 1;
                    }
                    if (grid[x][pos[1]] > 0) {
                        grid[x][pos[1]] *= -1;
                        deque.offer(new int[]{x, pos[1]});
                    }
                    xMax = Math.max(xMax, x + grid[pos[0]][pos[1]]);
                    x++;
                }
                int yMax = pos[1] + Math.abs(grid[pos[0]][pos[1]]);
                int y = pos[1] + 1;
                while (y <= yMax && y < cols) {
                    if (pos[0] == rows - 1 && y == cols - 1) {
                        return level + 1;
                    }
                    if (grid[pos[0]][y] > 0) {
                        grid[pos[0]][y] *= -1;
                        deque.offer(new int[]{pos[0], y});
                    }
                    yMax = Math.max(yMax, y + grid[pos[0]][pos[1]]);
                    y++;
                }
            }
        }
        return -1;
    }

    public int minimumVisitedCells(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        if (grid[0][0] == 0) {
            return rows == 1 && cols == 1 ? 1 : -1;
        }
        PriorityQueue<Node> rowHeap = new PriorityQueue<>();
        PriorityQueue<Node>[] colHeaps = new PriorityQueue[cols];
        Arrays.setAll(colHeaps, id -> new PriorityQueue<>());
        for (int i = 0; i < rows; i++) {
            rowHeap.clear();
            for (int j = 0; j < cols; j++) {
                if (i == 0 && j == 0) {
                    rowHeap.offer(new Node(1, j + grid[i][j]));
                    colHeaps[j].offer(new Node(1, i + grid[i][j]));
                    continue;
                }
                while (!rowHeap.isEmpty() && rowHeap.peek().rightMax < j) {
                    rowHeap.remove();
                }
                while (!colHeaps[j].isEmpty() && colHeaps[j].peek().rightMax < i) {
                    colHeaps[j].remove();
                }
                int cost = Integer.MAX_VALUE;
                if (rowHeap.isEmpty() && colHeaps[j].isEmpty()) {
                    if (i == rows - 1 && j == cols - 1) {
                        return -1;
                    }
                    continue;
                }
                if (!rowHeap.isEmpty()) {
                    cost = rowHeap.peek().cost + 1;
                }
                if (!colHeaps[j].isEmpty()) {
                    cost = Math.min(cost, colHeaps[j].peek().cost + 1);
                }
                if (i == rows - 1 && j == cols - 1) {
                    return cost;
                }
                if (grid[i][j] > 0) {
                    rowHeap.offer(new Node(cost, j + grid[i][j]));
                    colHeaps[j].offer(new Node(cost, i + grid[i][j]));
                }
            }
        }
        return -1;
    }


    private static class Node implements Comparable<Node> {

        private int cost;
        private int rightMax;


        public Node(int cost, int rightMax) {
            this.cost = cost;
            this.rightMax = rightMax;
        }

        @Override
        public int compareTo(@NotNull Lc2617MinimumVisitedCells.Node o) {
            return cost - o.cost;
        }
    }


}
