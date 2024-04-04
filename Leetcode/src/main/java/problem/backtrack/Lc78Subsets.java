package problem.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Lc78Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>(1));
        for (int win = 1; win <= nums.length; win++) {
            dfs(nums, 0, win, new ArrayList<>(), result);
        }
        return result;
    }

    private void dfs(int[] nums, int i, int window, List<Integer> path, List<List<Integer>> result) {
        if (path.size() >= window) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int j = i; j < nums.length; j++) {
            if (j + window - i - 1 >= nums.length) {
                break;
            }
            path.add(nums[j]);
            dfs(nums, j + 1, window, path, result);
            path.remove(path.size() - 1);
        }
    }
}
