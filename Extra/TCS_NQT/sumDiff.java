package Extra.TCS_NQT;
//Given a maximum of 100 digits numbers as input, write a program to find the
//difference between the sum of odd and even position digits.

import java.util.Scanner;

public class sumDiff {
    public static void main(String[] args) {
        Scanner sin = new Scanner(System.in);
//        String s=sin.nextLine();
        String s = "25698346";
        long num = 0, num1 = 0;
        num = num + s.charAt(0)-'0';

        for(int i=1;i<s.length();i++)
        {
            if(i%2==0)
                num = num + s.charAt(i)-'0';
            else
                num1 = num1 + s.charAt(i)-'0';
        }
        System.out.println(Math.abs(num-num1));
    }
}
