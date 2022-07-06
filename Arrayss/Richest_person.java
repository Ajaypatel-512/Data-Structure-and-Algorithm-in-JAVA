package Arrayss;

//1672. Richest Customer Wealth
//https://leetcode.com/problems/richest-customer-wealth/

public class Richest_person {
    public static void main(String[] args) {
        int[][] account = {
                {1,2,3},
                {3,2,1}
        };


    }
    public int maximumWealth(int[][] accounts) {
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < accounts.length; i++) {
            int rowsum = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                rowsum += accounts[i][j];
            }
            if (rowsum > ans){
                ans = rowsum;
            }
        }
        return ans;
    }
}
