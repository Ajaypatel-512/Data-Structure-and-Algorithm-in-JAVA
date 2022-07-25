package Extra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MaximumCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<n; i++){
            arr.add(sc.nextInt());
        }
        int max = Collections.max(arr);
        if(max > 9) {
            while (max >= 10) {
                arr.remove(arr.indexOf(max));
                int m = max / 2;
                arr.add(m);
                arr.add(max-m);
                max = Collections.max(arr);
            }
        }
        System.out.println(max +" "+arr.size());
    }
}
