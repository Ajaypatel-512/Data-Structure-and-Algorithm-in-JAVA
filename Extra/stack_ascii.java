package Extra;

import java.util.Scanner;

public class stack_ascii {
    public int test(int i){
        if(i<1){
            return 1;
        }else{
            return 0;
        }
    }


    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        char c = sc.next().charAt(0);
//
//        System.out.println(c%3);

        stack_ascii s = new stack_ascii();
        int i = s.test(1);
        System.out.println(i);



    }
    // abcfgh       fc
//    void popStack(char[] s){
//        char result[1000] = "-404";
//        int j=0;
//        for(int i=s.length()-1; i>=0; i-- ){
//            if((int)s[i] % 3 ==0){
//                result[j] = s[i];
//                j++;
//            }
//        }
//
//        puts(result);
//    }
}
