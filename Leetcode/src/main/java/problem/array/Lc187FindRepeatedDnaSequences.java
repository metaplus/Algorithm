package problem.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lc187FindRepeatedDnaSequences {

    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> set = new HashMap<>();
        List<String> res = new ArrayList<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String sub = s.substring(i, i + 10);
            if (set.merge(sub, 1, Integer::sum) == 2) {
                res.add(sub);
            }
        }
        return res;
    }
}
