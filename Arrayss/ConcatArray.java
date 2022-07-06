package Arrayss;

public class ConcatArray {
    public static void main(String[] args) {
        int[] nums = {1,2,1};
        System.out.println(getConcatenation(nums));
    }
    public static int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n+n];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = nums[i];
        }
        return nums;
    }
}
