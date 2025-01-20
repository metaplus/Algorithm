package problem.hashmap;

import java.util.*;

public class Lc347TopKFrequent {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> freq=new HashMap<>();
        for (int num : nums) {
            freq.merge(num,1,Integer::sum);
        }
        PriorityQueue<int[]> queue=new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            queue.add(new int[]{entry.getKey(), entry.getValue()});
            if(queue.size()>k){
                queue.poll();
            }
        }
        int[] result=new int[k];
        for (int i = 0; i < k; i++) {
            result[k-1-i]=queue.poll()[0];
        }
        return result;
    }
    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        TreeMap<Integer, List<Integer>> reverse = new TreeMap<>(Comparator.reverseOrder());
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            reverse.computeIfAbsent(entry.getValue(), key -> new ArrayList<>(2))
                    .add(entry.getKey());
        }
        int[] result = new int[k];
        int index = -1;
        for (Map.Entry<Integer, List<Integer>> entry : reverse.entrySet()) {
            for (Integer i : entry.getValue()) {
                if (++index < k) {
                    result[index] = i;
                    continue;
                }
                break;
            }
            if (index >= k) {
                break;
            }
        }
        return result;
    }
}
