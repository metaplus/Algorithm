package problem.search.binary;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lc1146SnapshotArray {

    class SnapshotArray {

        private int snapId = 0;
        private List<int[]>[] array;

        public SnapshotArray(int length) {
            array = new List[length];
        }

        public void set(int index, int val) {
            if (Objects.isNull(array[index])) {
                array[index] = new ArrayList<>(4);
            }
            array[index].add(new int[]{val, snapId});
        }

        public int snap() {
            return snapId++;
        }

        public int get(int index, int snap_id) {
            if (Objects.isNull(array[index]) || array[index].isEmpty()) {
                return 0;
            }
            int left = 0;
            int right = array[index].size();
            while (left < right) {
                int mid = (left + right) / 2;
                if (array[index].get(mid)[1] <= snap_id) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left == 0 ? 0 : array[index].get(left - 1)[0];
        }
    }
}
