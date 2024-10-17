package MathsNumSys;

import java.util.ArrayList;
import java.util.Collections;

public class MaximumSwapNum {
    /**
     * 670. Maximum Swap
     *
     * You are given an integer num. You can swap two digits at most once to get the maximum valued number.
     *
     * Return the maximum valued number you can get.
     *
     * Example 1:
     *
     * Input: num = 2736
     * Output: 7236
     * Explanation: Swap the number 2 and the number 7.
     * Example 2:
     *
     * Input: num = 9973
     * Output: 9973
     * Explanation: No swap.
     * */
    public static void main(String[] args) {
        System.out.println(maximumSwap1(2736));
        System.out.println(maximumSwap2(2736));
    }

    //Solution 1 Brute Force O(N2)
    public static int maximumSwap1(int num) {
        String numStr = Integer.toString(num);
        char[] numArray = numStr.toCharArray();
        int maxNum = num;

        for (int i = 0; i < numArray.length; ++i) {
            for (int j = i + 1; j < numArray.length; ++j) {
                char temp = numArray[i];
                numArray[i] = numArray[j];
                numArray[j] = temp;

                int newNum = Integer.parseInt(new String(numArray));
                maxNum = Math.max(maxNum, newNum);

                temp = numArray[i];
                numArray[i] = numArray[j];
                numArray[j] = temp;
            }
        }

        return maxNum;
    }

    //Solution 2
    public static int maximumSwap2(int num) {
            ArrayList<Integer> numList = new ArrayList<>();
            int temp = num;

            while (temp > 0) {
                numList.add(0, temp % 10);
                temp /= 10;
            }


            ArrayList<Integer> sortedNumList = new ArrayList<>(numList);
            Collections.sort(sortedNumList);


            for (int i = 0; i < numList.size(); i++) {
                if (numList.get(i) != sortedNumList.get(sortedNumList.size() - i - 1)) {
                    int swapIndex = numList.lastIndexOf(sortedNumList.get(sortedNumList.size() - i - 1));
                    Collections.swap(numList, i, swapIndex);
                    break;
                }
            }

            int result = 0;
            for (int digit : numList) {
                result = result * 10 + digit;
            }

            return result;
        }
}
