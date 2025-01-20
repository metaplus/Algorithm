package problem.greedy;

import java.util.Objects;
import java.util.PriorityQueue;

public class Lc1953NumberOfWeeks {


    public long numberOfWeeks(int[] milestones) {
        int timeMax = milestones[0];
        long sum = milestones[0];
        for (int i = 1; i < milestones.length; i++) {
            timeMax = Math.max(timeMax, milestones[i]);
            sum += milestones[i];
        }
        if (timeMax > sum - timeMax + 1) {
            return (sum - timeMax) * 2L + 1;
        }
        return sum;
    }

    // tle
    public long numberOfWeeks2(int[] milestones) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
        for (int i = 0; i < milestones.length; i++) {
            queue.offer(new int[]{i, milestones[i]});
        }
        int[] last = null;
        int[] head = null;
        int count = 0;
        while (!queue.isEmpty()) {
            head = queue.poll();
            count++;
            if (--head[1] == 0) {
                if (Objects.nonNull(last)) {
                    queue.offer(last);
                    last = null;
                }
                continue;
            }
            int[] add = last;
            last = head;
            if (Objects.nonNull(add)) {
                queue.offer(add);
            }
        }
        if (Objects.nonNull(last)
                && last[0] != head[0]) {
            count++;
        }
        return count;
    }
}
