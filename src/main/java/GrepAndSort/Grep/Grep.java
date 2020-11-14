package GrepAndSort.Grep;

import GrepAndSort.Interfaces.Methods;
import org.w3c.dom.ls.LSOutput;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Grep implements Methods {
    private String inputString;
    private String filter;

    public Grep(String inputString, String filter) {
        this.inputString = inputString;
        this.filter = filter;
    }

    public String getInputString() {
        return inputString;
    }

    public void setInputString(String inputString) {
        this.inputString = inputString;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    @Override
    public void grep() {
        if(getInputString().isEmpty() || getFilter().isEmpty()) {
            System.out.println("Введите данные!");
        } else {
            Stream<String> stringStream = Stream.of(getInputString().split("[\\p{Punct}\\s]+"));
            String result = stringStream.filter(s -> s.contains(getFilter()))
                    .map(String::toLowerCase)
                    .collect(Collectors.joining(", "));
            if(result.isEmpty()) {
                System.out.println("Совпадений не найдено!");
            } else System.out.println(result);
            /*stringStream.filter(s -> s.contains(getFilter()))
                    .map(String::toLowerCase)
                    .sorted()
                    .forEach(s1 -> {
                                if (s1.equalsIgnoreCase("")) {
                                    System.out.println("Совпадений не найдено!");
                                } else System.out.print(s1 + " ");
                            } );
                           //*/
        }

    }
}
