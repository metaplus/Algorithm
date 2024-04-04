package problem.backtrack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Lc22GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        StringBuilder builder = new StringBuilder(n * 2);
        List<String> result = new ArrayList<>();
        dfsOpen(n, 0, 0, 0, builder, result);
        return result;
    }

    public void dfsOpen(int n, int i, int open, int close, StringBuilder builder, List<String> result) {
        if (i == n * 2) {
            result.add(builder.toString());
            return;
        }
        for (int j = 1; j <= n - open; j++) {
            for (int k = 0; k < j; k++) {
                builder.append('(');
            }
            dfsClose(n, i + j, open + j, close, builder, result);
            builder.delete(i, i + j);
        }
    }

    public void dfsClose(int n, int i, int open, int close, StringBuilder builder, List<String> result) {
        if (i == n * 2) {
            result.add(builder.toString());
            return;
        }
        for (int j = 1; j <= open - close; j++) {
            for (int k = 0; k < j; k++) {
                builder.append(')');
            }
            dfsOpen(n, i + j, open, close + j, builder, result);
            builder.delete(i, i + j);
        }
    }


    public List<String> generateParenthesis2(int n) {
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
