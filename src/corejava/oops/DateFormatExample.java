import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * Java program to show how to format date in Java using SimpleDateFormat
 * Examples. Java allows to include date, time and timezone information
 * while formatting dates in Java.
 *
 * @author http://java67.blogspot.com
 */
public class DateFormatExample {

    public static void main(String args[]) {
     
        // This is how to get today's date in Java
        Date today = new Date();
     
        //If you print Date, you will get un formatted output
        System.out.println("Today is : " + today);
     
        //formatting date in Java using SimpleDateFormat
        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
        String date = DATE_FORMAT.format(today);
        System.out.println("Today in dd-MM-yyyy format : " + date);
     
        //Another Example of formatting Date in Java using SimpleDateFormat
        DATE_FORMAT = new SimpleDateFormat("dd/MM/yy");
        date = DATE_FORMAT.format(today);
        System.out.println("Today in dd/MM/yy pattern : " + date);
     
        //formatting Date with time information
        DATE_FORMAT = new SimpleDateFormat("dd-MM-yy:HH:mm:SS");
        date = DATE_FORMAT.format(today);
        System.out.println("Today in dd-MM-yy:HH:mm:SS : " + date);
     
        //SimpleDateFormat example - Date with timezone information
        DATE_FORMAT = new SimpleDateFormat("dd-MM-yy:HH:mm:SS Z");
        date = DATE_FORMAT.format(today);
        System.out.println("Today in dd-MM-yy:HH:mm:SSZ : " + date);
     
    }
 
}
