package Arrayss;

import java.util.ArrayList;
import java.util.HashMap;

public class note {
    public static void main(String[] args) {
        int input1 = 15;
        int input2 = 6;
        int[] arr = {1,4,20,3,10,5};
        System.out.println(moneyconfusion(input1,input2,arr));
    }
    public static int moneyconfusion(int input1, int input2, int[] money) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0, maxLen = 0;

        for (int i = 0; i < input2; i++) {            sum += money[i];
            if (sum == input1)
                maxLen = i + 1;
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }

            if (map.containsKey(sum - input1)) {
                if (maxLen < (i - map.get(sum - input1)))
                    maxLen = i - map.get(sum - input1);
            }
        }
        return maxLen;

    }
}
