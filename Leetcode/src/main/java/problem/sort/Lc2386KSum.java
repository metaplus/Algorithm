package problem.sort;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Lc2386KSum {

    public long kSum(int[] nums, int k) {
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                sum += nums[i];
                continue;
            }
            nums[i] = -nums[i];
        }
        Arrays.sort(nums);
        PriorityQueue<Sequence> sequences = new PriorityQueue<>((a, b) -> Long.compareUnsigned(a.sum, b.sum));
        sequences.add(new Sequence(0, -1));
        for (int i = 0; i < k - 1; i++) {
            Sequence seq = sequences.poll();
            if (seq.last + 1 < nums.length) {
                sequences.add(new Sequence(seq.sum + nums[seq.last + 1], seq.last + 1));
                if (seq.last >= 0) {
                    sequences.add(new Sequence(seq.sum + nums[seq.last + 1] - nums[seq.last], seq.last + 1));
                }
            }
        }
        return sum - sequences.peek().sum;
    }

    private static class Sequence {

        private long sum;
        private int last;

        public Sequence(long sum, int last) {
            this.sum = sum;
            this.last = last;
        }
    }
}
