package problem.search.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc46Permute {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>(64);
        dfs(nums, new boolean[nums.length], 0, new ArrayList<>(nums.length), result);
        return result;
    }

    private void dfs(int[] nums, boolean[] visit, int index, List<Integer> path, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visit[i]) {
                continue;
            }
            visit[i] = true;
            path.add(nums[i]);
            dfs(nums, visit, index + 1, path, result);
            visit[i] = false;
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs2(nums, 0, new ArrayList<>(nums.length), new boolean[nums.length], res);
        return res;
    }

    private void dfs2(int[] nums, int i, List<Integer> path, boolean[] visit, List<List<Integer>> res) {
        if (i >= nums.length) {
            return;
        }
        for (int j = 0; j < nums.length; j++) {
            if (visit[j]) {
                continue;
            }
            path.add(nums[j]);
            visit[j] = true;
            if (path.size() == nums.length) {
                res.add(new ArrayList<>(path));
            } else {
                dfs2(nums, i + 1, path, visit, res);
            }
            path.remove(path.size() - 1);
            visit[j] = false;
        }
    }
}
