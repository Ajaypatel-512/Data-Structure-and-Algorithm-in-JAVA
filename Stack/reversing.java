package Stack;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class reversing {
    public static void main(String[] args) {
        String s = "ajay patel";
        String s1 = "";

        Stack<Character> sta = new Stack<>();
        for(int i=0; i<s.length(); i++){
            sta.push(s.charAt(i));
        }
        Iterator it = sta.iterator();
        while(it.hasNext()){
            s1 += sta.pop();
        }

        System.out.println(s1);
//        System.out.println(sta.push('a'));
//
//        if(sta.isEmpty()){
//            System.out.println("underflow conditon");
//        }else{
//            System.out.println(sta.peek());
//        }

    }
}
