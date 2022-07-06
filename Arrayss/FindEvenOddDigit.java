package Arrayss;

//leetcode problm 1295
//https://leetcode.com/problems/find-numbers-with-even-number-of-digits/

public class FindEvenOddDigit {
    public static void main(String[] args) {
        int[] nums = {12,345,2,6,7896};
//        int[] nums = {555,901,482,1771};

        int ans = findNumbers(nums);
        System.out.println(ans);
    }
    public static int findNumbers(int[] nums) {
        int count = 0;
        for (int num: nums) {
            if (evenOdd(num)){
                count++;
            }
        }
        return count;
    }

    static boolean evenOdd(int nums){
        int noOfDigits = digit(nums);
        return noOfDigits % 2 == 0;
    }

    static int digit(int num){
        if(num < 0){
            num = num * -1;
        }
//        if(num == 0){
//            return  1;
//        }
//        int count=0;
//        while(num > 0){
//            count++;
//            num = num/10;
//        }
//        return count;

        return (int) (Math.log10(num))+1;
    }
}
