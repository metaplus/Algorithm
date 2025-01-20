package problem.search.dfs;

import java.util.ArrayList;
import java.util.List;

public class Lc46Permute {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>(nums.length), new boolean[nums.length], res);
        return res;
    }

    private void dfs(int[] nums, int i, List<Integer> path, boolean[] visit, List<List<Integer>> res) {
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
                dfs(nums, i + 1, path, visit, res);
            }
            path.remove(path.size() - 1);
            visit[j] = false;
        }
    }
}
