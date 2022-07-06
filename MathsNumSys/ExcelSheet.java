package MathsNumSys;

public class ExcelSheet {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(convertToTitle(n));
    }
    public static String convertToTitle(int columnNumber) {
        String ans = "";
        for(int i=1; i<=26; i++){
            if(i == columnNumber){
                ans = String.valueOf((char)(i + 64));
            }
        }
        if(columnNumber > 26){
        }
        return ans;
    }
}
