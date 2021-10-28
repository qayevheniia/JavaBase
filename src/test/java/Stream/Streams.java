package Stream;



import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;


public class Streams {

    private final List<Employee> emps = List.of(
            new Employee("Yevgeniia", " Motytskaya", 243, 43, Position.CHEF),
            new Employee("Igor", "Motyt", 245, 45, Position.MANAGER),
            new Employee("Luda", "Mihailenko", 278, 50, Position.WORKER)
    );

    private final List<Department> deps = List.of(
            new Department(1, 0, "Head"),
            new Department(2, 1, "West"),
            new Department(3, 1, "East")
    );


    public void creation() throws IOException {
//        поиск по названию файла
//       Stream<String> lines = Files.lines(Paths.get("some.txt"));
//       поиск по полном пути
        Stream<Path> list = Files.list(Paths.get("./"));
        //       поиск дереву папек
        Stream<Path> walk = Files.walk(Paths.get("./"), 3);

//     создание стрима из примитивніх типов данніх
        IntStream intStream = IntStream.of(1, 2, 3);
        DoubleStream doubleStream = DoubleStream.of(1, 2, 3);

//        массив примитивных инджерев от до
        IntStream range = IntStream.range(10, 100); // 10 .. 99
        IntStream intStream1 = IntStream.rangeClosed(10, 100); // 10 .. 100

//        перевод массива инджера в стрим
        int[] ints = {1, 2, 3, 4};
        IntStream stream = Arrays.stream(ints);

//        стрим стрингов
        Stream.of("1", "2", "3");
        Stream<String> stringStream = Stream.of("1", "2", "3");


        // стрим с разными типами данных
        Stream.of(1, "2", "3");
        Stream<? extends Serializable> stream1 = Stream.of(1, "2", "3");

        Stream<String> build = Stream.<String>builder()
                .add("Mike")
                .add("Test")
                .build();

        Stream<Employee> stream2 = emps.stream();

//        возвращает с 1950 года с интервалом в 3 года
        Stream<Event> generate = Stream.generate(() -> new Event(UUID.randomUUID(), LocalDateTime.now(), ""));
        Stream.iterate(1950, val -> +3);

        // возвращает билдер строк
        Stream<String> concat = Stream.concat(stringStream, build);
        System.out.println(concat);
    }


    public void terminate() {

        System.out.println(emps.stream().count());

        emps.forEach(e
                -> System.out.println(e.getAge()));
        emps.stream().collect(Collectors.toList());
        emps.stream().toArray();

        Map<Integer, String> collect = emps.stream().collect(Collectors.toMap(
                emp -> emp.getId(),
//                Employee::getId, используем лямду вместо вызова метода
                emp -> String.format("%s %s", emp.getLastName(), emp.getFirstName())
        ));
        collect.entrySet().stream().forEach(e -> System.out.println(e));

//    сложить массив из интеджеров

        IntStream intS = IntStream.of(100, 200, 300);
        intS.reduce((left, right) -> left + right).getAsInt();

//        добавляем обьекты. Создаем для этого рекурсию
        System.out.println(deps.stream().reduce(this::reducer));

//        средний из сумм инт
        IntStream.of(100, 200, 300).average();
        IntStream.of(100, 200, 300).max();
        IntStream.of(100, 200, 300).summaryStatistics().getAverage();

//        считаем максимум из обьектов исходя из их возраста
        System.out.println(emps.stream().max(Comparator.comparingInt(a -> a.getAge())));
    }


    //рекурсия
    public Department reducer(Department parent, Department child) {
        if (child.getParent() == parent.getId()) {
            parent.getChild().add(child);
        } else {
            parent.getChild().forEach(subParent -> reducer(subParent, child));
        }
        return parent;
    }
}


    class streamToString {
public static void main(String args[]){
        Stream.of("dd2","aa2","bb1"," bb3","cc4")
        .filter(s->{
        System.out.println("Фильтр"+s);
        return true;
        })
        .forEach(s->System.out.println("Печать с использованием forEach:"+s));
        }
        }

//        Фильтрdd2
//Печать с использованием forEach:dd2
//Фильтрaa2
//Печать с использованием forEach:aa2
//Фильтрbb1
//Печать с использованием forEach:bb1
//Фильтр bb3
//Печать с использованием forEach: bb3
//Фильтрcc4
//Печать с использованием forEach:cc4


    class streamToStringSecond {
        public static void main(String args[]) {
            Stream.of("dd2", "aa2", "bb1", "bb3", "cc4")
                    .forEach(s -> System.out.println("Печать с использованием forEach:" + s));
        }
    }
//    Печать с использованием forEach:dd2
//Печать с использованием forEach:aa2
//Печать с использованием forEach:bb1
//Печать с использованием forEach:bb3
//Печать с использованием forEach:cc4


    class printAll {
        public static void main(String args[]) {
            String[] aaa = {"dd2", "aa2", "bb1"};
            Stream.of(aaa)
                    .map(s -> {
//                    System.out.println("map: "+s);
                        return s.toUpperCase();
                    })
                    .filter(e -> {
//                    System.out.println("filter:" +e);
                        return e.startsWith("A");
                    })
//                .forEach(System.out::println);
                    .forEach(e -> System.out.println("Fanal: " + e));
        }
    }
//     The goal of this exercise is to convert a string to a new string where each character
//     in the new string is "(" if that character appears only once in the original string,
//     or ")" if that character appears more than once in the original string.
//     Ignore capitalization when determining if a character is a duplicate.


    class DuplicateEncoder {
        public static void main(String args[]) {
            String str = "street";
            System.out.println(str.toLowerCase()
                    .chars()
                    .mapToObj(i -> String.valueOf((char) i))
                    .map(e -> {
                        if (str.indexOf(e) == str.lastIndexOf(e)) {
                            return "(";
                        } else {
                            return ")";
                        }
                    })
                    .collect(joining()));
        }
    }

   class squareDigits {
       public static void main(String args[]) {
           int n = 12131;
           System.out.println(Integer.parseInt(String.valueOf(n)
                   .chars()
                   .map(i -> Integer.parseInt(String.valueOf(Character.getNumericValue(i))))
                   .map(i -> i * i)
                   .mapToObj(String::valueOf)
                   .collect(joining(""))
           ));
       }
    }


    class highestNumber {
        public static void main(String args[]) {
            long nb = 94233945;
            System.out.println(Integer.parseInt(String.valueOf(nb)
                    .chars()
                    .mapToObj(i -> String.valueOf(Character.getNumericValue(i)))
                    .sorted(Comparator.reverseOrder())
                    .collect(joining())));
        }
    }


//    находим количетсво уникальных повторений. Загнлаи в стрим отфильтровали количество частоты повторений больше 1 раза,
    //убрали повторение и проверили длину
    class amountOfDublication {
    public static void main(String args[]) {
        String val = "fhuhuisf";
        List<String> list = Arrays.asList(val.toLowerCase().split(""));
        System.out.println((int) list
                .stream()
                .filter(a -> Collections.frequency(list, a) > 1).distinct().count());
    }
}
    //таже задача только из-за того что мы используем уникальное значение сет
// коллекции и поэтому нам сохранится только один раз оно а потом мы сможем вытащить длину этой строки

class duplicateCount {
        public static  void main(String args[]) {
            Set<String> count = new HashSet<>();
           String text = "tsvhgvty";
            for (String string : text.toLowerCase().split("")) {
                if (text.toLowerCase().indexOf(string) != text.toLowerCase().lastIndexOf(string)) count.add(string);
            }

            System.out.println(count.size());
        }
    }


    class characters {
        public static void main(String args[]) {
            String str = "testee";
            char[] strC = str.toCharArray();
            String result = "";
            if (strC.length % 2 == 0) {
                result = String.format("%s%s", strC[(strC.length / 2) - 1], strC[(strC.length / 2)]);
            } else {
                result = String.valueOf(strC[strC.length / 2]);
            }
            System.out.println(result);

        }
    }


    class telNumber {
        public static void main(String args[]) {
            int[] number = {2, 5, 1, 6, 8, 1, 9, 5, 6, 0};
            System.out.println(String.format("(%s%s%s) %s%s%s-%s%s%s%s", number[0], number[1], number[2], number[3], number[4], number[5], number[6], number[7], number[8], number[9]));
        }
    }


    class numbersOdd {
        public static void main(String args[]) {
            int[] numbers = {2, 4, 0, 100, 4, 11, 2602, 36};
            int[] odd = Arrays.stream(numbers).filter(i -> i % 2 == 0).toArray();
            int[] even = Arrays.stream(numbers).filter(i -> i % 2 != 0).toArray();
            System.out.println(odd.length > 1 ? even[0] : odd[0]);
        }

    }

    class summ {
        public static void main (String args[]){
            int[] line = {25, 25, 50, 100};
            int bill25 = 0, bill50 = 0;
            String result = "";
            for (int i = 1; i < line.length; i++) {
                bill25 += line[i];
                if (line[0] != 25) {
                    result = "NO";
                }
                if (bill25 < line[i]) {
                    result = "NO";
                }

            }
            System.out.println(result);
        }
    }

    //

   class linkedList {
       public static void main(String args[]) {
           //creating LinkedList with 5 elements including head
           LinkedList head = new LinkedList();
           head.add(1);
           head.add(2);
           head.add(3);
           int size = head.size() / 2;
           System.out.println(head.get(size));

           int count = 0;
           while (count <= size) {
               count++;
               if (count == size) {
                   System.out.println(head.get(size));
               }
           }
       }
   }




//    Напишите программу на Java для переворачивания строки, изменив расположение символов в строке задом наперёд без использования встроенных в String функций.
//через билдер

    class reverseWithoutString {
        public static void main(String args[]) {
            String str = "zxcvbnnadssdhsq";
            StringBuilder strNew = new StringBuilder(str);

            System.out.println(strNew.reverse());
        }
    }
    // Напишите программу на Java для переворота последовательности символов в строке без использования встроенной в String функции reverse().
//
class reverse{
    public static void main(String args[]) { {
        String str = "zxcvbnnadssdhsq";
        String[] strS = str.split("");
        String result = "";
        for (int i = strS.length - 1; i > 0; i--) {
            result += strS[i];
        }
        System.out.println(result);

    }}}

//    Это еще один способ выполнить задачу с переворотом последовательности символов в строке. В этом способе вы объявляете строковую переменную st, а затем используете класс Scanner, объявляя объект scannerQ для работы со стандартным потоком ввода данных.
//
//В данном случае программа примет строковое значение через командную строку (при ее выполнении).
//
//Далее мы использовали метод nextLine(), который прочитал нашу строку при вводе ее через консоль с пробелами между словами строки. После этого мы использовали метод split() для разделения строки на ее подстроки (здесь не указывается разделитель). Затем, мы выводим строку в обратном порядке, используя цикл for.

        class UsedScanner {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            System.out.println("Please add new text here");
            String str = in.nextLine();
            String[] strS = str.split("");
            String result = "";
            for (int i = strS.length - 1; i > 0; i--) {
                result += strS[i];
            }
            System.out.println(result);
        }
    }


//    способ реверса через чар

    class ReverceByChar {
        public static void main(String args[]) {
            String str = "zxcvbnnadssdhsq";
            int i = str.length() - 1;
            String result = "";
            while (0 <= i) {
                result += str.charAt(i);
                i--;
            }
            System.out.println(result);
        }
    }
//    Напишите программу на Java для того, чтобы поменять местами значения, хранящиеся в двух переменных с помощью третьей переменной

    class number {
        public static void main(String args[]) {
            {
                int a = 3;
                int b = 4;
                int c = 0;

                c = a + b;
                a = c - a;
                b = c - b;
                System.out.println(a + "" + b);
            }
        }
    }

    class numberWithoutThree {
        public static void main(String args[]) {
            int a = 3;
            int b = 4;

            a = a + b;
            b = a - b;
            a = a - b;
            System.out.println(a + "" + b);
        }
    }

//    Напишите программу на Java для подсчета количества конкретных слов в строке, используя HashMap

    class hashMap {
public static void main(String args[]){
        String str="Hi. I am Yevgeniia am I am am";

        String[]strings=str.split(" ");
        HashMap<String, Integer> hashu=new HashMap<>();
        for(String word:strings
        ){
        if(hashu.containsKey(word)){
        int counter=hashu.get(word);
        hashu.put(word,counter+1);
        }else{
        hashu.put(word,1);
        }

        }
        System.out.println(hashu);
        }
        }

    //    6) Напишите Java-программу для итерации объекта типа HashMap с использованием цикла while и улучшенного цикла for.

    class iterations {
        public static void main(String args[]) {
            HashMap<Integer, Object> hashMap = new HashMap<>();
            hashMap.put(1, "String");
            hashMap.put(2, 123);
            hashMap.put(3, 323);

            for (Map.Entry newHash : hashMap.entrySet()
            ) {
                System.out.println(newHash.getKey() + " " + newHash.getValue());

            }

            Iterator iter = hashMap.entrySet().iterator();

            while (iter.hasNext()) {

                Map.Entry qurentMe = (Map.Entry) iter.next();

                System.out.println("Ключ это " + qurentMe.getKey() + " Значение это " + qurentMe.getValue());

            }
            hashMap.entrySet().stream().forEach(System.out::println);

        }
    }

    //    Q # 8) Напишите Java-программу, чтобы определить, является ли строка или число палиндромом, или нет.

    class palindrom {
        public static void main(String args[]) {
            String polindrom = "test";
            String polindrom2 = " teet";
            boolean result = false;

            for (int i = 0; i < polindrom.length(); i++) {
                if (polindrom.toCharArray()[i] == polindrom2.toCharArray()[polindrom2.toCharArray().length - 1 - i]) {
                    result = true;
                } else {
                    result = false;
                    break;
                }
            }
            System.out.println(result);
        }
    }
    //    Q # 8) Напишите Java-программу, чтобы определить, является ли строка или число палиндромом, или нет.


    class palindromByBuilder {
        public static void main(String args[]) {
            Scanner in = new Scanner(System.in);
            System.out.println("Please add new word");
            String firstWord = in.nextLine();
            System.out.println("Please add reverse word");
            String secondWords = in.nextLine();
            StringBuilder reverse = (new StringBuilder(secondWords)).reverse();
            boolean result = false;
            if (reverse.toString().equals(firstWord)) {
                result = true;
            } else {
                result = false;
            }

            System.out.println(reverse);

            System.out.println(result);


        }
        }

//         9) Написать программу на Java для вычисления серии чисел Фибоначчи. СЛЕДУЮЩАЯ сумма предыдущих

        class fibonacchi{
            public static void main (String [] args){
                Scanner in = new Scanner(System.in);
                System.out.println("Add number");
                int number = in.nextInt();
               int [] arrNumbers = Stream.of(String.valueOf(number).split("")).mapToInt(x-> Integer.parseInt(x)).toArray();
               for (int i=2; i<arrNumbers.length; i++){
                   arrNumbers[i]=(arrNumbers[i-1]+arrNumbers[i-2]);
               }
                System.out.println(Arrays.toString(arrNumbers));}
        }




