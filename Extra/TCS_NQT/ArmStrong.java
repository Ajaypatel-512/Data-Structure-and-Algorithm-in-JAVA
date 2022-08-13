package Extra.TCS_NQT;

import java.util.Scanner;

public class ArmStrong {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int n = s.nextInt();

//        if(isArmstrong(n)){
//            System.out.println(n + " is Armstrong");
//        }else {
//            System.out.println(n + " not an Armstrong");
//        }


        for (int i=0; i<=n; i++){
            if(isArmstrong(i)){
                System.out.print(i+" ");
            }
        }
    }

    public static boolean isArmstrong(int n){
        int digit = 0, sum =0, rem;
        int temp = n;
        while (temp > 0){
            digit++;
            temp = temp/10;
        }
        temp = n;
        while(temp>0){
            rem = temp %10;
            sum += Math.pow(rem,digit);
            temp = temp/10;
        }
        if(sum == n){
            return true;
        }
        return false;
    }
}
