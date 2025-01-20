package problem.search.dfs;

import java.util.ArrayList;
import java.util.List;

public class Lc78Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result =new ArrayList<>(32);
        dfs(nums,0,new ArrayList<>(8),result);
        return result;
    }

    private void dfs(int[] nums,int index,List<Integer> comb,List<List<Integer>> result){
        if(index==nums.length){
            result.add(new ArrayList<>(comb));
            return;
        }
        comb.add(nums[index]);
        dfs(nums,index+1,comb,result);
        comb.remove(comb.size()-1);
        dfs(nums,index+1,comb,result);
    }
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>(1));
        for (int win = 1; win <= nums.length; win++) {
            dfs2(nums, 0, win, new ArrayList<>(), result);
        }
        return result;
    }

    private void dfs2(int[] nums, int i, int window, List<Integer> path, List<List<Integer>> result) {
        if (path.size() >= window) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int j = i; j < nums.length; j++) {
            if (j + window - i - 1 >= nums.length) {
                break;
            }
            path.add(nums[j]);
            dfs2(nums, j + 1, window, path, result);
            path.remove(path.size() - 1);
        }
    }
}
