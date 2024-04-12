package problem.deque;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Lc502FindMaximizedCapital {

    //todo
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        Cell[] cells = new Cell[profits.length];
        for (int i = 0; i < cells.length; i++) {
            cells[i] = new Cell(profits[i], capital[i]);
        }
        Arrays.sort(cells, (a, b) -> {
            if (a.capital != b.capital) {
                return a.capital - b.capital;
            }
            return b.profit - a.profit;
        });
        PriorityQueue<Cell> queue = new PriorityQueue<>(k, Comparator.comparingInt(a -> a.profit));
        int profitSum = 0;
        for (int i = 0; i < cells.length; i++) {
            if (profitSum < cells[i].capital) {
                return profitSum;
            }
            if (queue.size() < k) {
                queue.offer(cells[i]);
                profitSum += cells[i].profit;
                continue;
            }
            if (queue.peek().profit >= cells[i].profit) {
                continue;
            }
            profitSum -= queue.poll().profit;
            profitSum += cells[i].profit;
            queue.offer(cells[i]);
        }
        return profitSum;
    }

    private static class Cell {

        int profit;
        int capital;

        public Cell(int profit, int capital) {
            this.profit = profit;
            this.capital = capital;
        }

        @Override
        public String toString() {
            return "Cell{" +
                    "profit=" + profit +
                    ", capital=" + capital +
                    '}';
        }
    }
}
