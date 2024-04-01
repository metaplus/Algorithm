package problem.tree;

import java.util.ArrayList;
import java.util.List;

public class Lc386LexicalOrder {

    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>(n);
        int val = 1;
        for (int i = 0; i < n; i++) {
            res.add(val);
            if (val * 10 <= n) {
                val *= 10;
                continue;
            }
            while (val + 1 > n || val % 10 == 9) {
                val /= 10;
            }
            val++;
        }
        return res;
    }
}
