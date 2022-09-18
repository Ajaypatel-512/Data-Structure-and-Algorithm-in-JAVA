package Arrayss;

import java.util.Arrays;
import java.util.Scanner;

public class largestNumAtLeastTwice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(dominantIndex(arr));
    }
    public static int dominantIndex(int[] nums) {
        if (nums.length < 1){
            return 0;
        }

        int largest = Integer.MIN_VALUE;
        int maxIndex = 0;
        int second = Integer.MIN_VALUE;
        int minIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > largest) {
                second = largest;
                largest = nums[i];
                maxIndex++;
            }
            else if (nums[i] > second && nums[i] != largest)
                second = nums[i];
            minIndex++;
        }

        if(largest >= second*2 || second == 0){
            int index = Arrays.binarySearch(nums, largest);
            return (index < 0) ? 0 : index;
        }
        return -1;
    }
}
