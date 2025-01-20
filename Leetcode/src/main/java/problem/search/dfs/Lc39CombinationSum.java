package problem.search.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc39CombinationSum {


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>(32);
        dfs(candidates, 0, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void dfs(int[] candidates, int index, int target, int pre,
                     List<Integer> comb, List<List<Integer>> result) {
        if (index >= candidates.length) {
            return;
        }
        int step = 0;
        for (int sum = pre + candidates[index]; sum <= target; sum += candidates[index]) {
            comb.add(candidates[index]);
            step++;
            if (target == sum) {
                result.add(new ArrayList<>(comb));
            } else {
                dfs(candidates, index + 1, target, sum, comb, result);
            }
        }
        for (int i = 0; i < step; i++) {
            comb.remove(comb.size() - 1);
        }
        dfs(candidates, index + 1, target, pre, comb, result);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates.length < 1) {
            return new ArrayList<>();
        }
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        dfs2(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    private void dfs2(int[] candidates, int target, int i, List<Integer> path, List<List<Integer>> res) {
        if (candidates[i] > target) {
            return;
        }
        for (int j = i; j < candidates.length; j++) {
            if (candidates[j] > target) {
                break;
            }
            path.add(candidates[j]);
            int remain = target - candidates[j];
            if (remain == 0) {
                res.add(new ArrayList<>(path));
            } else {
                dfs2(candidates, remain, j, path, res);
            }
            path.remove(path.size() - 1);
        }
    }
}
