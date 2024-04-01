package problem.tree;

public class Lc1306CanReach {

    public boolean canReach(int[] arr, int start) {
        return dfs(arr, start, new boolean[arr.length]);
    }

    private boolean dfs(int[] arr, int id, boolean[] visit) {
        if (id < 0 || id > arr.length - 1 || visit[id]) {
            return false;
        }
        visit[id] = true;
        if (arr[id] == 0) {
            return true;
        }
        if (dfs(arr, id - arr[id], visit)) {
            return true;
        }
        return dfs(arr, id + arr[id], visit);
    }
}
