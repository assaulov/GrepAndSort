package GrepAndSort;

import GrepAndSort.Grep.Grep;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        final String STOP = "stop";
        if (args.length == 0) {
            Process p = Runtime.getRuntime().exec("cmd.exe /c start java -jar " + (new File(Main.class.getProtectionDomain().getCodeSource().getLocation().getPath())).getAbsolutePath() + " cmd");

        } else {

            while (true) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Введите слова: ");
                var inputString = scanner.nextLine();
                System.out.println("Введите фильтр: ");
                var filter = scanner.nextLine().toLowerCase();
                Grep grep = new Grep(inputString, filter);
                System.out.print("Результат применения фильтра: ");
                grep.grep();
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
}