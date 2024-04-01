package problem.deque;

import java.util.*;

public class Lc218GetSkyline {

    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        List<int[]> walls = new ArrayList<>(buildings.length * 2);
        for (int[] building : buildings) {
            walls.add(new int[]{building[0], -building[2]});
            walls.add(new int[]{building[1], building[2]});
        }
        walls.sort((a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
        TreeMap<Integer, Integer> heightMap = new TreeMap<>();
        int last = 0;
        for (int[] wall : walls) {
            if (wall[1] < 0) {
                if (heightMap.isEmpty() || heightMap.lastKey() < -wall[1]) {
                    res.add(item(wall[0], -wall[1]));
                    last = -wall[1];
                }
                heightMap.merge(-wall[1], 1, Integer::sum);
                continue;
            }
            heightMap.compute(wall[1], (k, v) -> v == 1 ? null : v - 1);
            if (heightMap.isEmpty()) {
                last = 0;
                res.add(item(wall[0], 0));
                continue;
            }
            if (heightMap.lastKey() == last) {
                continue;
            }
            res.add(item(wall[0], heightMap.lastKey()));
            last = heightMap.lastKey();
        }
        return res;
    }

    List<Integer> item(int a, int b) {
        List<Integer> list = new ArrayList<>(2);
        list.add(a);
        list.add(b);
        return list;
    }

    public List<List<Integer>> getSkyline2(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        int id = 0;
        PriorityQueue<int[]> leftMin = new PriorityQueue<>(Comparator.comparingInt(arr -> arr[0]));
        PriorityQueue<int[]> rightMin = new PriorityQueue<>(Comparator.comparingInt(arr -> arr[1]));
        PriorityQueue<int[]> rightMax = new PriorityQueue<>(Comparator.comparingInt(arr -> -arr[1]));
        PriorityQueue<int[]> heightMax = new PriorityQueue<>(Comparator.comparingInt(arr -> -arr[2]));
        while (id < buildings.length) {
            while (rightMax.isEmpty() || (id < buildings.length && buildings[id][0] <= rightMax.peek()[1])) {
                leftMin.add(buildings[id]);
                rightMin.add(buildings[id]);
                rightMax.add(buildings[id]);
                id++;
            }
            while (!rightMin.isEmpty()) {
                while (!leftMin.isEmpty() && leftMin.peek()[0] <= rightMin.peek()[1]) {
                    int[] pos = leftMin.poll();
                    heightMax.add(pos);
                    res.add(item(pos[0], heightMax.peek()[2]));
                }
                int[] pos = rightMin.poll();
                heightMax.remove(pos);
                rightMax.remove(pos);
                while (!rightMin.isEmpty() && rightMin.peek()[1] == pos[1]) {
                    pos = rightMin.poll();
                    heightMax.remove(pos);
                    rightMax.remove(pos);
                }
                res.add(item(pos[1], heightMax.isEmpty() ? 0 : heightMax.peek()[2]));
            }
        }
        List<Integer> last = null;
        ListIterator<List<Integer>> iterator = res.listIterator();
        while (iterator.hasNext()) {
            List<Integer> val = iterator.next();
            if (Objects.nonNull(last) && Objects.equals(val.get(0), last.get(0))) {
                last.set(1, Math.max(val.get(1), last.get(1)));
                iterator.remove();
                continue;
            }
            last = val;
        }
        iterator = res.listIterator();
        last = null;
        while (iterator.hasNext()) {
            List<Integer> val = iterator.next();
            if (Objects.nonNull(last) && Objects.equals(val.get(1), last.get(1))) {
                iterator.remove();
                continue;
            }
            last = val;
        }
        return res;
    }


}
