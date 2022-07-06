package Arrayss;

import java.util.Arrays;
import java.util.Scanner;

class Main {
	public static void main (String[] args) {
                      // Your code here
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		if(N<1 || N>1000){
			return;
		}
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		int max = Arrays.stream(arr).max().getAsInt();
		int res = max;

		int j = -1;
		while (j<N){
			int sum = 0;
			for(int i=0; i<N; i++){
				sum = sum+arr[i];
			}
			if(sum > res){
				res = sum;
			}
			j++;
			if(j>=N) break;
			arr[j] = K;
		}

		System.out.println(res);

//			int j = 0;
//			while(j<N){
//
//			}
//			for (int i = 0,j=0; i < N ; i++) {
//				arr[j] = K;
//				sum = sum+arr[i];
//
//				if(sum > res){
//					res = sum;
//				}else {
//					j++;
//				}
//			}




















//			int sum = Integer.MIN_VALUE;
//			if((N>0 && N<11) && (X>0 && X<=1000) ){
//				for (int i = 1; i <= N; i++) {
//					X = X * 2;
//				}
//				System.out.print(X);
//			}
	}
}