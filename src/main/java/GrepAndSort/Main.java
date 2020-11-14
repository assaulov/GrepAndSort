package GrepAndSort;

import GrepAndSort.Grep.Grep;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
/*
        final String STOP = "stop";
        if (args.length == 0) {
            Process p = Runtime.getRuntime().exec("cmd.exe /c start java -jar " +
                    (new File(Main.class.getProtectionDomain().getCodeSource().getLocation().getPath())).getAbsolutePath() + " cmd");

        } else {
*/
            while (true) {
                Grep grep = new Grep();
                var scanner = new Scanner(System.in);
                System.out.println("Введите слова: ");
                grep.setInputString(scanner.nextLine());
                System.out.println("Введите фильтр: ");
                grep.setFilter(scanner.nextLine().toLowerCase());
                System.out.print("Результат применения фильтра: ");
                grep.grep(grep.getInputString(), grep.getFilter());
                System.out.println("Если хотите продолжить нажмите любую клавишу. Введите \"stop\" для выхода.");
                if(scanner.nextLine().equalsIgnoreCase("stop")){
                    scanner.close();
                    System.out.println("Good Bye!");
                    Thread.sleep(2000);
                    System.exit(0);
                }

            }


        }

    }
//}