package problem.hashmap;

import java.util.*;

public class Lc599FindRestaurant {

    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        int sum = -1;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < list2.length; i++) {
            Integer index = map.get(list2[i]);
            if (Objects.isNull(index)) {
                continue;
            }
            if (sum < 0) {
                sum = index + i;
                set.add(list2[i]);
                continue;
            }
            if (i > sum) {
                break;
            }
            if (index + i < sum) {
                sum = index + i;
                set.clear();
                set.add(list2[i]);
                continue;
            }
            if (index + i == sum) {
                set.add(list2[i]);
            }
        }
        return set.toArray(new String[0]);
    }
}
