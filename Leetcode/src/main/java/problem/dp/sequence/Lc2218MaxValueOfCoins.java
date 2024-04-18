package problem.dp.sequence;

import java.util.List;

public class Lc2218MaxValueOfCoins {

    // todo
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        var f = new int[k + 1];
        var sumN = 0;
        for (var pile : piles) {
            var n = pile.size();
            for (var i = 1; i < n; ++i)
                pile.set(i, pile.get(i) + pile.get(i - 1)); // pile 前缀和
            sumN = Math.min(sumN + n, k); // 优化：j 从前 i 个栈的大小之和开始枚举（不超过 k）
            for (var j = sumN; j > 0; --j)
                for (var w = 0; w < Math.min(n, j); ++w)
                    f[j] = Math.max(f[j], f[j - w - 1] + pile.get(w)); // w 从 0 开始，物品体积为 w+1
        }
        return f[k];
    }
}
