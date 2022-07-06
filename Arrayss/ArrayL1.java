package Arrayss;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayL1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>(2);
//        list.add(12);
//        list.add(100);
//        list.add(12);
//        list.add(1);
//        list.add(12);
//        list.add(14);
//        list.add(99);
//        list.add(66);
//        list.add(2345);
//
//        System.out.println(list);
//
//        System.out.println((list.contains(12)));
//        System.out.println(list.indexOf(100));
//        list.remove(8);
//        list.set(0,101);
//        System.out.println(list);

        for (int i = 0; i < 5; i++) {
            list.add(sc.nextInt());
        }

        for (int i = 0; i < 5; i++) {
            System.out.print(list.get(i)+ " ");
        }
        System.out.println("\n"+list);

    }
}
