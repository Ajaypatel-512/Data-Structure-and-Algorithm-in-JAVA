package Arrayss;

public class MinimumArrayEnd {
    public static void main(String[] args) {
        System.out.println(minEnd(3,4));
    }

    //Solution 1 O(n) O(1)
    public static long minEnd(int n, int x) {
        long num = x;
        for (int i=1; i<n; i++){
            num = (num+1) | x;
        }
        return num;
    }
}
