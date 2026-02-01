package problem.heap.priority;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Lc857MincostToHireWorkers {

    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        Cell[] cells = new Cell[quality.length];
        Arrays.setAll(cells, i -> new Cell(quality[i], wage[i], ((double) wage[i]) / quality[i]));
        Arrays.sort(cells, Comparator.comparingDouble(cell -> cell.ratio));
        PriorityQueue<Cell> queue = new PriorityQueue<>(Comparator.comparingInt(cell -> -cell.quality));
        double wageSum = Double.MAX_VALUE;
        int qualSum = 0;
        for (Cell cell : cells) {
            queue.offer(cell);
            qualSum += cell.quality;
            if (queue.size() == k) {
                wageSum = Math.min(wageSum, cell.ratio * qualSum);
                qualSum -= queue.poll().quality;
            }
        }
        return wageSum;
    }

    private static class Cell {

        private int quality;
        private int wage;
        private double ratio;

        public Cell(int quality, int wage, double ratio) {
            this.quality = quality;
            this.wage = wage;
            this.ratio = ratio;
        }
    }
}
