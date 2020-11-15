package GrepAndSort;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GrepAndSort {

    static Scanner scanner = new Scanner(System.in);
    static final String GREP = "grep";
    static final String SORT = "sort";
    static final String STOP = "stop";
    static  final String CHOICE = "Программа для выборки из сторки по заданному фильтру: Grep.\n" +
                "Программа для сортировки слов строки по длине и алфавиту: Sort.\n" +
                "Выход : Stop.\n" +
                "Выберите программу для исполенния: ";

    public static void main(String[] args) throws IOException, InterruptedException {

            //Запуск консоли
        if (args.length == 0) {
            Runtime.getRuntime().exec("cmd.exe /c start java -Dfile.encoding=cp866 -jar " +
                    (new File(GrepAndSort.class.getProtectionDomain().getCodeSource().getLocation().getPath())).getAbsolutePath() + " cmd");

        } else {

            while (true) {
                //Вывод приветсвия
                System.out.println(CHOICE);
                var doChoice = scanner.nextLine();
                //Запуск программы в зависимости от выбора пользователя
                switch (doChoice.toLowerCase()) {
                    case (SORT) -> startSort(); // Звауск сортировки
                    case (GREP) -> startGrep(); // Запуск фильтра
                    case (STOP) -> { // Остановка программы
                        scanner.close();
                        System.out.println();
                        System.out.println("Good Bye!");
                        Thread.sleep(2000);
                        System.exit(0);
                    }
                    default -> System.out.println("Введите Grep или Sort");
                }


            }

        }
    }
            // Метод фильтра
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
    //Старт фильтра
        private static  void startGrep(){
            System.out.println();
            System.out.println("Grep");
            System.out.println();
            System.out.println("Введите слова: ");
            var  inputString = scanner.nextLine();
            System.out.println("Введите фильтр: ");
            var filter = scanner.nextLine().toLowerCase();
            System.out.print("Результат применения фильтра: ");
            grep(inputString, filter);
        }
        // Метод сортировки
        private static void sort(String inputString)  {
            if (inputString.isEmpty()) {
                System.out.println("Введите данные!");
            } else {
                Stream<String> stringStream = Stream.of(inputString.split("[\\p{Punct}\\s]+"));
                String result = stringStream.sorted(Comparator.comparing(String::length)
                        .thenComparing(String::compareToIgnoreCase))
                        .map(String::toLowerCase)
                        .collect(Collectors.joining("\n"));
                System.out.println(result);


            }
        }
        //Запуск сортировки
        private static void startSort()  {
            System.out.println();
            System.out.println("Sort");
            System.out.println();
            System.out.println("Введите сторку для сортировки: ");
            var inputString = scanner.nextLine();
            System.out.println("Результат сортировки по длине слова и алфавиту: ");
            sort(inputString);

        }
}
