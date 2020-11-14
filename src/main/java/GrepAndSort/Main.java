package GrepAndSort;

import GrepAndSort.Grep.Grep;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final String STOP = "stop";
        var scanner = new Scanner(System.in);
        System.out.println("Введите слова: ");
        var inputString = scanner.nextLine();
        System.out.println("Введите фильтр: ");
        var filter = scanner.nextLine().toLowerCase();
        Grep grep = new Grep(inputString, filter);
        System.out.print("Результат применения фильтра: ");
        grep.grep();


    }
}