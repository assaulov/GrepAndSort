package GrepAndSort.Grep;


import org.w3c.dom.ls.LSOutput;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Grep  {
    private String inputString;
    private String filter;


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


    public void grep(String inputString, String filter) {
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
}
