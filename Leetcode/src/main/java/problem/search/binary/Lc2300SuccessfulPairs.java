package problem.search.binary;

import java.util.Arrays;

public class Lc2300SuccessfulPairs {

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] result = new int[spells.length];
        for (int i = 0; i < spells.length; i++) {
            int left = 0;
            int right = potions.length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if ((long) spells[i] * potions[mid] < success) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            result[i] = potions.length - left;
        }
        return result;
    }

    public int[] successfulPairs2(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] result=new int[spells.length];
        for (int i = 0; i < spells.length; i++) {
            result[i] = potions.length- binarySearch(spells[i],potions,success);
        }
        return result;
    }

    private int  binarySearch(int spell,int[] potions, long success ){
        if(potions.length==0){
            return 0;
        }
        int left=0;
        int right=potions.length-1;
        int result= potions.length;
        while (left<=right){
            int mid=left+(right-left)/2;
            long mul=spell;
            mul*= potions[mid];
            if (mul >= success) {
                right=mid-1;
                result=mid;
            }else {
                left=mid+1;
            }
        }
        return result;
    }
}
