package Arrayss;

import java.util.ArrayList;
import java.util.Collections;

public class LargestCombinationWithBitwise {
    public static void main(String[] args) {
        int[] candidates = {16,17,71,62,12,24,14};
        System.out.println(largestCombination(candidates));
    }

    //Solution 1
    public static int largestCombination(int[] candidates) {
        ArrayList<Integer> setBit=new ArrayList<>(24);
        for (int i = 0; i < 24; i++) {
            setBit.add(0);
        }
        System.out.println(setBit);
        for(int num:candidates){
            for(int i=0;i<24;i++){
                if((num&(1<<i))!=0){
                    setBit.set(i,setBit.get(i)+1);
                }
            }
        }
        return Collections.max(setBit);
    }
}
