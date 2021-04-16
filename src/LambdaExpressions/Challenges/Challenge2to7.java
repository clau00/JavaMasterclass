package LambdaExpressions.Challenges;

import java.util.Comparator;
import java.util.concurrent.Callable;
import java.util.function.Function;
import java.util.function.Supplier;

public class Challenge2to7 {

    public static void main(String[] args) {
        String input = "1234567";
        System.out.println(everySecondChar(input));

        //  RESULT
        Function<String, String> everySecondCharWithLambda = s -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i=0; i<s.length(); i++){
                if (i % 2 == 1){
                    returnVal.append(s.charAt(i));
                }
            }
            return returnVal.toString();
        };

        String resultChallenge5 = doChallenge4(everySecondCharWithLambda, "1234567890");
        System.out.println(resultChallenge5);

        // Challenge 6 + 7: Use a supplier to return a string and print it out
        Supplier<String> iLoveJava = () -> "I Love Java!";
        String supplierResult = iLoveJava.get();
        System.out.println(supplierResult);


    }

    //  Write the following method as a lambda expression.
    public static String everySecondChar(String source){
        StringBuilder returnVal = new StringBuilder();
        for (int i=0; i<source.length(); i++){
            if (i % 2 == 1){
                returnVal.append(source.charAt(i));
            }
        }
        return returnVal.toString();
    }

    public static String doChallenge4(Function<String, String> challenge4, String source){
        return challenge4.apply(source);
    }
    
}
