
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Array {
    public static final class Account {
        private float money;
        private String name;

        public void setMoney(float money) {
            this.money = money;
        }

        public void setName(String name) {
            this.name = name;
        }

        public float getMoney() {
            return money;
        }

        public String getName() {
            return name;
        }
    }



    public static void main(String [] args){
        Account [] accounts = new Account[5];

        accounts[0]= new Account();
        accounts[0].setName("Petrov0");
        accounts[0].setMoney(1000f);

        accounts[1]= new Account();
        accounts[1].setName("Petrov1");
        accounts[1].setMoney(1000f);

        accounts[2]= new Account();
        accounts[2].setName("Petrov2");
        accounts[2].setMoney(1000f);

        accounts[3]= new Account();
        accounts[3].setName("Petrov3");
        accounts[3].setMoney(1000f);

        accounts[4]= new Account();
        accounts[4].setName("Petrov4");
        accounts[4].setMoney(1000f);

        for(int i=0; i< accounts.length; i++){
            float currentSalary = accounts[i].getMoney();
            currentSalary +=currentSalary*0.1f;
            accounts[i].setMoney(currentSalary);
        }

        for (Account account:accounts){
            System.out.println(account.getMoney() +" " +account.getName());
        }

    }


    //        Write a program that finds the summation of every number from 1 to num.
//        The number will always be a positive integer greater than 0.

//        https://nimb.ws/8PmHWr

    public void Summ(){
        int number = 10;
        int i=0;
        int summ=0;
        while(i<number){
            summ +=i;
            i++;
        }
        System.out.println(summ);
    }


    //            1. Program to print the duplicate elements of an array
//            In this program, we need to print the duplicate elements present in the array.
//            This can be done through two loops.
//            The first loop will select an element and the second loop will iteration through the array
//            by comparing the selected element with other elements.
//            If a match is found, print the duplicate element.
//
//                    Program to print the duplicate elements of an array
//            In the above array, the first duplicate will be found at the index 4 which is the duplicate of the element (2) present at index 1. So, duplicate elements in the above array are 2, 3 and 8.
//            Algorithm
//            STEP 1: START
//            STEP 2: INITIALIZE arr[]= {1, 2, 3, 4, 2, 7, 8, 8, 3}.
//                    STEP 3: PRINT "Duplicate elements in given array:"
//            STEP 4: REPEAT STEP 5 to STEP 7 for(i=0; i<arr.length; i++)
//                STEP 5: REPEAT STEP 6 and STEP 7 for(j=i+1; j<arr.length; j++)
//                STEP 6: if(arr[i] == arr[j])
//                STEP 7: PRINT arr[j]
//            STEP 8: END

    public void Dublication(){
        int[] array = {1,4,6,2,1,6,7};

        for(int i =0; i<array.length; i++){
            for(int k=i+1; k<array.length; k++){
                if(array[i]==array[k]){
                    System.out.print(array[i]);
                }
            }
        }
    }


//     3. Program to print the elements of an array in reverse order
//            In this program, we need to print the elements of the array in reverse order that is; the last element should be displayed first, followed by second last element and so on.
//
//                    Program to print the elements of an array in reverse order

    public void ReverseOrder(){
        int [] array = {1,2,3,4,5,6,7,8,9};
        ArrayList <Integer> newList = new ArrayList<Integer>();

        for(int k=array.length-1;k>=0; k--){

            newList.add(array[k]);
        }
        System.out.println(Arrays.deepToString(newList.toArray()));
//        Numbers.forEach((n) -> System.out.println(n));
        newList.forEach((n) -> System.out.print(n));
        // or


//        for (int [] newList1: newList
//             ) {
//            System.out.println(newList1);
        }

    public void solution() {
        String str= "123456";
        char [] newStr=str.toCharArray();

//        char [] result = new char [newStr.length];
    String result ="";
    int k=0;
    for(int i=newStr.length-1; i>=0; i-- ){

            result +=newStr[i];
            k++;
    }
    System.out.println((result ));
    }



  public void squareDigits() {
              int n = 91119;
            List<Integer>  list = new ArrayList<>();

    while((Math.log10(n))>0){
                list.add(n%10);
                n/=10;
            }
            List<Integer>  listNumber = new ArrayList<>();
            for(int a:list){
                listNumber.add(a*a);
            }
            String newS = String.valueOf(listNumber);
            System.out.print(newS);
    }

}


