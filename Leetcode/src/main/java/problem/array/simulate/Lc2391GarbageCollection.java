package problem.array.simulate;

public class Lc2391GarbageCollection {

    public int garbageCollection(String[] garbage, int[] travel) {
        int rightG = -1;
        int rightP = -1;
        int rightM = -1;
        int countG = 0;
        int countP = 0;
        int countM = 0;
        for (int i = 0; i < garbage.length; i++) {
            for (char c : garbage[i].toCharArray()) {
                switch (c) {
                    case 'M': {
                        rightM = i;
                        countM++;
                        break;
                    }
                    case 'P': {
                        rightP = i;
                        countP++;
                        break;
                    }
                    case 'G': {
                        rightG = i;
                        countG++;
                        break;
                    }
                }
            }
        }
        int[] prefix = new int[travel.length];
        prefix[0] = travel[0];
        for (int i = 1; i < travel.length; i++) {
            prefix[i] = prefix[i - 1] + travel[i];
        }
        int sum = countP + countM + countG;
        if (rightP > 0) {
            sum += prefix[rightP - 1];
        }
        if (rightG > 0) {
            sum += prefix[rightG - 1];
        }
        if (rightM > 0) {
            sum += prefix[rightM - 1];
        }
        return sum;
    }
}
