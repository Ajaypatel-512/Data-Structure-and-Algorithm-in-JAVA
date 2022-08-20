package Extra.TCS_NQT;

import java.util.Scanner;

// tcs nqt 20/08/2013
public class Bob {
    public static void ans(int[] arr, int N, int k){
        int i=0,j=0,res=0;
        int temp = 0;
        while(j<N){
            temp += arr[j];
            if(temp<k){
                j += 1;
            }else{
                temp -= arr[i];
                i += 1;
                j += 1;
            }
            res = Math.max(res,j-i);
        }
        System.out.println(res);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] goldChain = new int[N];
        for(int i=0; i<N; i++){
            goldChain[i] = sc.nextInt();
        }
        ans(goldChain,N,K);
    }
}
