package GrepAndSort;



import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GrepAndSort {
    static Scanner scanner = new Scanner(System.in);
    static final String GREP = "Grep";
    static final String SORT = "Sort";
    public static void main(String[] args) throws IOException, InterruptedException {
/*
        final String STOP = "stop";
        if (args.length == 0) {
            Process p = Runtime.getRuntime().exec("cmd.exe /c start java -jar " +
                    (new File(Main.class.getProtectionDomain().getCodeSource().getLocation().getPath())).getAbsolutePath() + " cmd");

        } else {
*/
            while (true) {

               startGrep();
                    System.out.println("Если хотите продолжить нажмите любую клавишу. Введите \"stop\" для выхода.");
                    if(scanner.nextLine().equalsIgnoreCase("stop")){
                    scanner.close();
                    System.out.println("Good Bye!");
                    Thread.sleep(2000);
                    System.exit(0);
                }

            }


        }

        private static void grep(String inputString, String filter) {
        if(inputString.isEmpty() || filter.isEmpty()) {
            System.out.println("Введите данные!");
        } else {
            Stream<String> stringStream = Stream.of(inputString.split("[\\p{Punct}\\s]+"));
            String result = stringStream.filter(s -> s.contains(filter))
                    .map(String::toLowerCase)
                    .collect(Collectors.joining(", "));
            if(result.isEmpty()) {
                System.out.println("Совпадений не найдено!");
            } else System.out.println(result);

        }

    }

        private static  void startGrep(){
            System.out.println("Grep");
            System.out.println();
            System.out.println("Введите слова: ");
            var  inputString = scanner.nextLine();
            System.out.println("Введите фильтр: ");
            var filter = scanner.nextLine().toLowerCase();
            System.out.print("Результат применения фильтра: ");
            grep(inputString, filter);
    }

    

    }
//}