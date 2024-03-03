package problem.sort;

public class Lc506FindRelativeRanks {

    public String[] findRelativeRanks(int[] scores) {
        int gap = findGap(scores.length);
        Rank[] ranks = new Rank[scores.length];
        for (int i = 0; i < scores.length; i++) {
            ranks[i] = new Rank(scores[i], i);
        }
        for (int i = gap; i > 0; i = (i - 1) / 3) {
            for (int j = 0; j < i; j++) {
                insertSort(ranks, j, i);
            }
        }
        String[] result = new String[scores.length];
        for (int i = 0; i < ranks.length; i++) {
            if (i > 2) {
                result[ranks[i].index] = Integer.toString(i + 1);
                continue;
            }
            if (i == 2) {
                result[ranks[i].index] = "Bronze Medal";
            } else if (i == 1) {
                result[ranks[i].index] = "Silver Medal";
            } else {
                result[ranks[i].index] = "Gold Medal";
            }
        }
        return result;
    }


    public void insertSort(Rank[] ranks, int start, int gap) {
        for (int i = start + gap; i < ranks.length; i += gap) {
            for (int j = i - gap; j >= 0; j -= gap) {
                if (ranks[j].score > ranks[j + gap].score) {
                    break;
                }
                Rank swap = ranks[j];
                ranks[j] = ranks[j + gap];
                ranks[j + gap] = swap;
            }
        }
    }

    public int findGap(int length) {
        int gap = 1;
        int gap1;
        while ((gap1 = 3 * gap + 1) < length) {
            gap = gap1;
        }
        return gap;
    }

    public static class Rank {

        private int score;
        private int index;

        public Rank(int score, int index) {
            this.score = score;
            this.index = index;
        }
    }
}
