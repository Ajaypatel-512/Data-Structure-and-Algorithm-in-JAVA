package Recursion;

import java.util.ArrayList;
import java.util.List;

public class AllSubsequenceWithSumK {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 5;
        System.out.println("All subsequences with sum " + k + ":");
        List<Integer> temp = new ArrayList<>();
        findSubsequences(arr, 0, temp, k);
    }

    private static void findSubsequences(int[] arr, int idx, List<Integer> temp, int sum) {
        if (idx == arr.length) {
            int currentSum = temp.stream().mapToInt(Integer::intValue).sum();
            if (currentSum == sum) {
                System.out.println(temp);
            }
            return;
        }

        // Include the current element
        temp.add(arr[idx]);
        findSubsequences(arr, idx + 1, temp, sum);
        // Exclude the current element
        temp.remove(temp.size() - 1);
        findSubsequences(arr, idx + 1, temp, sum);

    }


}
