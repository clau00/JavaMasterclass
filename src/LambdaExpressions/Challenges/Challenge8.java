package LambdaExpressions.Challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Challenge8 {

    public static void main(String[] args) {

        // 8. Print the following list in sorted order and with the first letter in each name upper-cased.
        List<String> topNames2015 = Arrays.asList(
                "Amelia",
                "Olivia",
                "emily",
                "Isla",
                "Ava",
                "oliver",
                "Jack",
                "harry",
                "Jacob"
        );

        List<String> firstUpperCaseList = new ArrayList<>();

        //  Result 1
        topNames2015.forEach(name -> firstUpperCaseList.add(name.substring(0,1).toUpperCase() + name.substring(1)));
        firstUpperCaseList.sort(String::compareTo);
        firstUpperCaseList.forEach(System.out::println);

        System.out.println(" ======================== ");

        //  Result 2
        topNames2015
                .stream()
                .map(s -> s.substring(0,1).toUpperCase() + s.substring(1))
                .sorted()
                .forEach(System.out::println);

        long namesStartingWithA = topNames2015
                .stream()
                .map(s -> s.substring(0,1).toUpperCase() + s.substring(1))
                .filter(s -> s.startsWith("A"))
                .count();
        System.out.println("The number of names starting with 'A': " + namesStartingWithA);

    }
}
