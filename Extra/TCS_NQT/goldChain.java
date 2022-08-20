package Extra.TCS_NQT;

import java.util.Scanner;

// tcs nqt 20/08/2023
public class goldChain {
    public static void ans(int[] arr, int N, int k){
        int[] ans = new int[N];
        int c = 0,e=0,s=0;
        for(int i=0; i<N; i++){
            if(c<k){
                c+=arr[e];
                e++;
            }
            if(c>=k)
                break;
        }
        for(int i=0; i<N; i++){
            if(c==k){
                System.out.println(s+1+" "+e);
                return;
            }
            else if(c>k){
                c-=arr[s];
                s++;
            }
        }
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
