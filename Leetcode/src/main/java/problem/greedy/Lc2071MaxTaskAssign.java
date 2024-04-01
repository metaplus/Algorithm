package problem.greedy;

import java.util.*;

public class Lc2071MaxTaskAssign {

    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);
        int left = 0, right = Math.min(tasks.length, workers.length);
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (canAssign(tasks, workers, pills, strength, mid)) {
                left = mid;
                continue;
            }
            right = mid - 1;
        }
        return left;
    }

    public boolean canAssign(int[] tasks, int[] workers, int pills, int strength, int size) {
        TreeMap<Integer, Integer> workerMap = new TreeMap<>(Comparator.reverseOrder());
        for (int i = workers.length - size; i < workers.length; i++) {
            workerMap.merge(workers[i], 1, Integer::sum);
        }
        for (int i = size - 1; i >= 0; i--) {
            Map.Entry<Integer, Integer> worker = workerMap.floorEntry(tasks[i]);
            if (Objects.nonNull(worker)) {
                workerMap.compute(worker.getKey(), (k, v) -> v == 1 ? null : v - 1);
                continue;
            }
            if (pills <= 0) {
                return false;
            }
            worker = workerMap.floorEntry(tasks[i] - strength);
            if (Objects.isNull(worker)) {
                return false;
            }
            workerMap.compute(worker.getKey(), (k, v) -> v == 1 ? null : v - 1);
            pills--;
        }
        return true;
    }

    // fail
    public int maxTaskAssign2(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);
        int count = 0;
        for (int i = 0, j = 0; i < tasks.length && j < workers.length; ) {
            if (tasks[i] <= workers[j]) {
                count++;
                tasks[i] *= -1;
                workers[j] *= -1;
                i++;
                j++;
                continue;
            }
            j++;
        }
        for (int i = 0, j = 0; i < tasks.length && j < workers.length; ) {
            if (tasks[i] < 0) {
                i++;
                continue;
            }
            if (workers[j] < 0) {
                j++;
                continue;
            }
            if (pills > 0 && tasks[i] <= workers[j] + strength) {
                pills--;
                count++;
                i++;
                j++;
                continue;
            }
            j++;
        }
        return count;
    }
}
