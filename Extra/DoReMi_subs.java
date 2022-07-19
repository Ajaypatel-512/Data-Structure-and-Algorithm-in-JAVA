package Extra;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class DoReMi_subs {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\ap075\\Desktop\\demo.txt");
//        Scanner sc = new Scanner(file);
//
//        while (sc.hasNextLine()) {
//            if(sc.next().contains("MUSIC")){
//                System.out.println(sc.nextLine());
//            }
//            else if (sc.next().contains("VIDEO")) {
//                System.out.println(sc.nextLine());
//            }
//            else if (sc.next().contains("PODCAST")) {
//                String s = sc.nextLine();
//                System.out.println(s);
//            }
////            if (sc.next().equals("FOUR_DEVICE")) {
////                System.out.println(sc.nextLine());
////            }
//            System.out.println(sc.nextLine());
//        }

        FileReader fr=new FileReader(file);   //reads the file
        BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream
        StringBuffer sb=new StringBuffer();    //constructs a string buffer with no characters
        String line;
        while((line = br.readLine())!=null)
        {
            sb.append(line);
            sb.append("\n");
        }
        fr.close();
//        System.out.println("Contents of File: ");
        System.out.println(sb.toString());
        boolean date = isValidDate(sb.substring(0,10));

    }
    public static boolean isValidDate(String inDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(inDate.trim());
        } catch (ParseException pe) {
            return false;
        }
        return true;
    }
}
