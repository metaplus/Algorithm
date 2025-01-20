package problem.array.simulate;

import java.util.Objects;

public class Lc551CheckRecord {

    public boolean checkRecord(String s) {
        if (Objects.isNull(s) || s.isEmpty()) {
            return false;
        }
        int absent = 0;
        int late = 0;
        for (char c : s.toCharArray()) {
            switch (c) {
                case 'A': {
                    if (++absent == 2) {
                        return false;
                    }
                    late = 0;
                    break;
                }
                case 'L': {
                    if (++late == 3) {
                        return false;
                    }
                    break;
                }
                default: {
                    late = 0;
                }
            }
        }

        return true;
    }
}
