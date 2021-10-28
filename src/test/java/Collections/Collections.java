package Collections;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Collections {
    public static void main(String[] args) throws IOException {
        FileInputStream stream = new FileInputStream("C:/Users/yevge/OneDrive/Desktop/Tools for formed costs/EWTcost.csv");
   int length = stream.available();
   byte [] data = new byte [length];
   stream.read(data);
 ArrayList <String []> lineWords = new ArrayList<>();
   String text  = new String(data);
  String [] lines =  text.split("\n");

       for(String line: lines){
           lineWords.add(line.split(","));
       }
        HashMap<String, String> map = new HashMap<>();
    for(String [] words: lineWords){

        map.put(words[0], words[3]);
//        if(words[0].equals("130")){
//     for (String word: words){
//         System.out.println(word);
//     }
// }
    }
        System.out.println(map.get("130"));
    }
}
