package InputOutput.Exceptions;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class SecondExample {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try{
            int result = divide();
            System.out.println(" / result = " + result);
        }catch(ArithmeticException | NoSuchElementException e){
            System.out.println(e.toString());
            System.out.println("Unable to perform division, autopilot shutting down...");
        }
    }

    private static int divide(){
        int x, y;
//        try {
            x = getInt();
            y = getInt();
            System.out.println("x is " + x + ", y is " + y);
            return x / y;
//        }catch(NoSuchElementException e){
//            throw new ArithmeticException("no suitable input");
//        }catch(ArithmeticException e){
//            throw new ArithmeticException("attempt to divide by zero");
//        }
    }

    private static int getInt(){
        System.out.println("Please insert an integer: ");
        while(true){
            try {
                return scanner.nextInt();
            }catch(InputMismatchException e){
                scanner.nextLine();
                System.out.println("Please insert a number using only digits from 0 to 9");
            }
        }
    }
}
