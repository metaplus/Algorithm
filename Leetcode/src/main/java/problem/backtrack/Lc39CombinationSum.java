package problem.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc39CombinationSum {


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length < 1) {
            return new ArrayList<>();
        }
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int[] candidates, int target, int i, List<Integer> path, List<List<Integer>> res) {
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
                dfs(candidates, remain, j, path, res);
            }
            path.remove(path.size() - 1);
        }
    }
}
