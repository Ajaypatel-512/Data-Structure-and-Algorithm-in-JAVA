package String;

import java.util.Scanner;

public class countChar {
    public static void main(String[] args) {
//        String str = "leetcode";
//        int count = 0;
//        char search = 'e';
//
//        for(int i=0; i<str.length(); i++){
//            if(str.charAt(i) == search){
//                count++;
//            }
//        }
//        System.out.println(search +" : "+ count);

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        countFriendsPairings(n);

    }
    static int countFriendsPairings(int n)
    {
        int dp[] = new int[n + 1];

        // Filling dp[] in bottom-up manner using
        // recursive formula explained above.
        for (int i = 0; i <= n; i++) {
            if (i <= 2)
                dp[i] = i;
            else
                dp[i] = dp[i - 1] + (i - 1) * dp[i - 2];
        }

        return dp[n];
    }
}
