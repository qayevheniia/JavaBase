import org.testng.annotations.Test;

public class Switch {

    //Write a Java program to find the number of days in a month.
    //
    //Test Data
    //Input a month number: 2
    //Input a year: 2016
    //Expected Output :
    //February 2016 has 29 days

@Test
    public void NameOfMonth(){
        int NumberOfMonth = 2;
        int year = 2012 ;
        int amountDay = 0;
        String nameMounth;
        switch (NumberOfMonth){
            case(1):
                nameMounth = "January";
                break;
            case (3):
                nameMounth = "March";
                break;
            case (4):
                nameMounth = "April";
                amountDay = 30;
                break;
            case (2):   if(year%4==0){
                amountDay = 29;
            } else {
                amountDay = 28;
            }
            nameMounth = "February";

                break;
            default:
                throw new IllegalStateException("Unexpected value: " + NumberOfMonth);
        }
        System.out.println(nameMounth +amountDay);

    }
}
