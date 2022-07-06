package Function;

import java.util.Scanner;

public class maxMin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter any three numbers");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        System.out.println("The max of three number is "+max(a,b,c));
        System.out.println("The max of three number is "+min(a,b,c));

    }
    public static int max(int a,int b,int c){
        int maxVal = a;
        if(maxVal < b){
            maxVal = b;
        }
        if(maxVal < c ){
            maxVal = c;
        }
        return maxVal;
    }
    public static int min(int a,int b,int c){
        int minVal = a;
        if(minVal > b){
            minVal = b;
        }
        if(minVal > c ){
            minVal = c;
        }
        return minVal;
    }
}
