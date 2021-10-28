
import javax.annotation.processing.Generated;
import java.beans.Transient;
import java.util.Scanner;

public class DifferentTasks {

    /*1. Write a Java program that reads a number in inches, converts it to meters.
                Note: One inch is 0.0254 meter.
                Test Data
        Input a value for inch: 1000
        Expected Output :
        1000.0 inch is 25.4 meters
 */

    public void convertarToMeters(){

        int NumberIntch = 1000;

        double NumberMeters = NumberIntch*0.0254;
        System.out.println(NumberMeters);
    }

    /*2. Write a Java program to convert minutes into a number of years and days.
Test Data
Input the number of minutes: 3456789
Expected Output :
3456789 minutes is approximately 6 years and 210 days
*/

    public void convertarTime(){

        int NumberMinutes = 2000000;
        int day = NumberMinutes/(60*24);
        int years = day/(365);
        int days = day%365;
       if(days<=0){
           days = day;
       }

        System.out.println("years: " +years +" days:" +days);
    }

}
