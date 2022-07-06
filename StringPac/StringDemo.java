package StringPac;

public class StringDemo {
    public static void main(String[] args) {
        /**
         * String a = "ajay";
         * String b = "ajay";
         * pointing to a same poll same object i.e ajay
         **/
        String a = "ajay";
        String b = "ajay";
//        System.out.println(a == b);       // check for same object
//        System.out.println(a.equals(b)); // check for same value

        /**
         * String c = new String("ajay");
         * String d = new String("ajay");
         * String e = new String("patel");
         * pointing to a different object i.e ajay, ajay, patel
         **/
        String c = new String("ajay");
        String d = new String("ajay");
        String e = new String("patel");
//        System.out.println(c == d);
//        System.out.println(c.equals(d));
//        System.out.println(d.equals(e));
/**
 * CharAt(index)  - give index value
 * **/
        System.out.println(a.charAt(0));
        System.out.println(e.charAt(0));


    }
}
