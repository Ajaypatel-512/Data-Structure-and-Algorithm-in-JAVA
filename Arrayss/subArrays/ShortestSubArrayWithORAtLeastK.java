package Arrayss.subArrays;

public class ShortestSubArrayWithORAtLeastK {
    public static void main(String[] args) {
        int[] num = {2,1,8};
        int k = 10;
        System.out.println(minimumSubarrayLength(num,k));
    }

    // Solution 1 O(N^2) O(1
    public static int minimumSubarrayLength(int[] nums, int k) {
        int left = 0, right = 0;
        int size = Integer.MAX_VALUE;
        int[] bitCount = new int[32];

        while (right < nums.length) {
            int num = nums[right++];
            int i = 0;
            while (num > 0) {
                bitCount[i++] += num % 2;
                num >>= 1;
            }

            num = createNum(bitCount);

            while (num >= k && left < right) {
                size = Math.min(size, right - left);
                int nl = nums[left++];
                i=0;
                while (nl > 0) {
                    bitCount[i++] -= nl % 2;
                    nl >>= 1;
                }
                num = createNum(bitCount);
            }
        }
        return size != Integer.MAX_VALUE ? size : -1;
    }

    private static int createNum(int[] bitCount) {
        int number = 0;
        for (int j = 31; j >= 0; j--) {
            number <<= 1;
            number += bitCount[j] > 0 ? 1 : 0;
        }
        return number;
    }
}
