package String;

public class DefangingIPAddress {
    public static void main(String[] args) {
        String address = "1.1.1.1";
        System.out.println(defangIPaddr(address));
    }
    public static String defangIPaddr(String address) {
        String replaceString = address.replaceAll("\\.","[.]");
        return replaceString;
    }
}
