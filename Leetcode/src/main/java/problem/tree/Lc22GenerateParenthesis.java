package problem.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Lc22GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if (n == 1) {
            list.add("()");
            return list;
        }
        Deque<Cell> deque = new ArrayDeque<>();
        deque.offer(new Cell(new int[n]));
        int level = 0;
        while (!deque.isEmpty() && level < n) {
            int size = deque.size();
            level++;
            while (size-- > 0) {
                Cell cell = deque.poll();
                if (level == n) {
                    Cell cell1 = new Cell(new int[n]);
                    System.arraycopy(cell.close, 0, cell1.close, 0, cell.close.length);
                    cell1.close[level - 1] = level - cell.sum;
                    cell1.sum = level;
                    cell1.level = level;
                    deque.add(cell1);
                    continue;
                }
                for (int i = 0; i <= level - cell.sum; i++) {
                    Cell cell1 = new Cell(new int[n]);
                    System.arraycopy(cell.close, 0, cell1.close, 0, cell.close.length);
                    cell1.close[level - 1] = i;
                    cell1.sum = cell.sum + i;
                    cell1.level = level;
                    deque.add(cell1);
                }
            }
        }
        for (Cell cell : deque) {
            char[] chars = new char[n * 2];
            int pre = 0;
            for (int i = 0; i < cell.close.length; i++) {
                for (int j = 0; j < cell.close[i]; j++) {
                    int id = i + 1 + pre + j;
                    chars[id] = ')';
                }
                pre += cell.close[i];
            }
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == 0) {
                    chars[i] = '(';
                }
            }
            list.add(new String(chars));
        }
        return list;
    }

    class Cell {

        int[] close;
        int sum;
        int level;

        public Cell(int[] close) {
            this.close = close;
        }
    }
}
