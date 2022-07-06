package StringPac;

import java.util.ArrayList;

public class Operators {
    public static void main(String[] args) {
//        System.out.println('a'+'b');
//        System.out.println("a"+"b");
//        System.out.println((char)(3+'a'));
        // Integer + string = integer will be converted to wrapper class integer  that will call toString method
        System.out.println("a"+1);  // same as "a" + "1"

        System.out.println("ajay" + new ArrayList<>());
        System.out.println("ajay" + new int[]{1,2,3});
//        System.out.println("ajay" + new Integer(24));

        //System.out.println(new Integer(24) + new ArrayList<>()); //error
        // + is only defined for primitive and only one of these is string

        System.out.println(new Integer(24) + " " + new ArrayList<>()); // works fine
        // because here atleast one string is there
        System.out.println();

    }
}
