package problem.greedy;

public class Lc134CanCompleteCircuit {


    public int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; ) {
            int sumGas = 0;
            int sumCost = 0;
            int next = -1;
            for (int j = 0; j < gas.length; j++) {
                int k = (i + j) % gas.length;
                sumGas += gas[k];
                sumCost += cost[k];
                if (sumGas < sumCost) {
//                    next = k + 1;
                    next = i + j + 1;
                    break;
                }
            }
            if (next < 0) {
                return i;
            }
            i = next;
        }
        return -1;
    }

    //timeout
    public int canCompleteCircuit2(int[] gas, int[] cost) {
        boolean[] visit = new boolean[gas.length];
        int diffMax = 0;
        int pos = 0;
        for (int i = 0; i < gas.length; i++) {
            if (gas[i] - cost[i] > diffMax) {
                diffMax = gas[i] - cost[i];
                pos = i;
            }
        }
        if (dfs(gas, cost, pos, 0, visit)) {
            return pos;
        }
        for (int i = 0; i < gas.length; i++) {
            if (i == pos) {
                continue;
            }
            if (gas[i] >= cost[i]) {
                if (dfs(gas, cost, i, 0, visit)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public boolean dfs(int[] gas, int[] cost, int i, int fuel, boolean[] visit) {
        if (visit[i]) {
            return true;
        }
        if (fuel + gas[i] - cost[i] < 0) {
            return false;
        }
        visit[i] = true;
        boolean result = dfs(gas, cost, (i + 1) % gas.length, fuel + gas[i] - cost[i], visit);
        visit[i] = false;
        return result;
    }
}
