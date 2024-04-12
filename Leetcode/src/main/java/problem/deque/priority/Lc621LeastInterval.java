package problem.deque.priority;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class Lc621LeastInterval {

    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char task : tasks) {
            count[task - 'A']++;
        }
        PriorityQueue<Cell> queue = new PriorityQueue<>(((a, b) -> {
            return Integer.compare(b.remain, a.remain);
        }));
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                queue.offer(new Cell(i, 0, count[i]));
            }
        }

        int index = 0;
//        List<Character> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            Iterator<Cell> iterator = queue.iterator();
            while (iterator.hasNext()) {
                Cell task = iterator.next();
                if (task.start > index) {
                    continue;
                }
//                list.add(((char) (task.task + 'A')));
                iterator.remove();
                if (--task.remain > 0) {
                    task.start = index + n + 1;
                    queue.offer(task);
                }
                break;
            }
            index++;
        }
        return index;
    }

    private static class Cell {

        int task;
        int start;
        int remain;

        public Cell(int task, int start, int remain) {
            this.task = task;
            this.start = start;
            this.remain = remain;
        }

        @Override
        public String toString() {
            return "Cell{" +
                    "task=" + task +
                    ", start=" + start +
                    ", remain=" + remain +
                    '}';
        }
    }
}
