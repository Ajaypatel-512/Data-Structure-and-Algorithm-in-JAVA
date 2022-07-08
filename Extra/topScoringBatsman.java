package Extra;

import java.util.Arrays;
import java.util.Scanner;

public class topScoringBatsman {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max = 0;
        String bat = "";
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = sc.next();
        }

//        String[] arr = new String[2];
//        for (int i = 0; i < str.length; i++) {
//             arr = str[i].split(",");
//        }
//        System.out.println(Arrays.toString(arr));
//
//
//        for (int j = 0; j < str.length; j++) {
//            if(Integer.parseInt(arr[1])>max){
//                max = Integer.parseInt(arr[1]);
//                Bat = arr[0];
//            }
//        }
//        System.out.println(Bat);

        String[] s2 = new String[str.length];
        for(String s : str) {
            s2 = s.split(",");
            for(int i = 1; i< s2.length; i+=2) {
                if(Integer.parseInt(s2[i]) > max){
                    max = Integer.parseInt(s2[i]);
                    bat = s2[i-1];
                }
            }
        }
        System.out.println(bat);
    }
}
