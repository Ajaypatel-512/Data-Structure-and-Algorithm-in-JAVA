package Arrayss;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class hcf {
    public static void main(String[] args) {

//        int num1 = 60, num2 = 84, hcf=0;
//        for (int i = 1; i <= num1 || i <= num2; i++){
//            if (num1 % i == 0 && num2 % i == 0)
//                hcf = i;
//        }
//        int a = num1/hcf;
//        int b = num2/hcf;
//
//        System.out.println(a+b);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] p = new int[n];
        int[] q = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            q[i] = sc.nextInt();
        }
        ans(n,p,q);

    }

    private static void ans(int n, int[] p, int[] q) {
        String s = "hello world";
        char[] ch = s.toCharArray();
        HashMap<Character,Integer> map = new HashMap<Character, Integer>();
        for (char c:ch) {
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }
            else
                map.put(c,1);
        }
        for (Map.Entry<Character,Integer> entry: map.entrySet()){
            if(entry.getValue()>1){
                System.out.println();
            }
        }

    }
//
//    public int jump(int[] nums) {
//        int n=nums.length;
//        int jump=1;
//        int max=nums[0];
//        int i=1;
//        while(i<n){
//            if(max>=n-1)return jump;
//            int point=max;
//            while(i<=point){
//                max=Math.max(max,i+nums[i]);
//                i++;
//            }
//            jump++;
//        }
//        return 0;
//    }



}
