package problem.graph;

import java.util.*;

public class Lc630ScheduleCourse {

    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, Comparator.comparingInt(arr -> arr[1]));
        PriorityQueue<int[]> queue = new PriorityQueue<>(courses.length, Comparator.comparingInt(arr -> -arr[0]));
        int time = 0;
        for (int[] course : courses) {
            if (time + course[0] <= course[1]) {
                time += course[0];
                queue.offer(course);
                continue;
            }
            if (!queue.isEmpty() && queue.peek()[0] > course[0]) {
                time -= queue.poll()[0] - course[0];
                queue.offer(course);
            }
        }
        return queue.size();
    }

    // timeout
    public int scheduleCourse2(int[][] courses) {
        Arrays.sort(courses, Comparator.comparingInt(arr -> arr[1] - arr[0]));
//        Arrays.sort(courses, Comparator.comparingInt(arr -> arr[0]));
        return dfs(courses, 1, 0, new boolean[courses.length]);
    }


    public int dfs(int[][] courses, int day, int i, boolean[] visit) {
//        if (day > courses[courses.length - 1][1] - courses[courses.length - 1][0] + 1) {
//            return 0;
//        }
        int count = 0;
        int duration = Integer.MAX_VALUE;
        List<Integer> list = new ArrayList<>();
        for (int j = i; j < courses.length; j++) {
            if (visit[j]) {
                continue;
            }
            if (day > courses[j][1] - courses[j][0] + 1) {
                continue;
            }
            if (courses[j][0] <= duration) {
                duration = courses[j][0];
                list.add(j);
            } else {
                continue;
            }

        }
        if (list.isEmpty()) {
            return 0;
        }
        for (Integer k : list) {
            visit[k] = true;
//            count = Math.max(count, dfs(courses, day + courses[j][0], j + 1, visit) + 1);
            count = Math.max(count, dfs(courses, day + courses[k][0], 0, visit) + 1);
            visit[k] = false;
        }
        return count;
    }
}
