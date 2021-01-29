package InputOutput.Exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FirstExample {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int x = 10;
        int y = 0;

        System.out.println(divideLBYL(x, y));
        System.out.println(divideEAFP(x, y));
//        System.out.println(divide(x, y));

//        x = getInt();
        x = getIntLBYL();
        System.out.println("x is: " + x);
        x = getIntEAFP();
        System.out.println("x is: " + x);
    }

    // will throw an exception on String inputs
    private static int getInt(){
        System.out.println("\tPlease insert an integer: ");
        return scanner.nextInt();
    }

    private static int getIntLBYL(){
        boolean isValid = true;
        System.out.println("\tPlease insert an integer: ");
        String input = scanner.next();
        for(int i=0; i<input.length(); i++){
            if(!Character.isDigit(input.charAt(i))){
                isValid = false;
                break;
            }
        }
        if(isValid){
            return Integer.parseInt(input);
        }
        return 0;
    }

    private static int getIntEAFP(){
        System.out.println("\tPlease insert an integer: ");
        try{
            return scanner.nextInt();
        }catch (InputMismatchException e){
            return 0;
        }
    }

    private static int divideEAFP(int x, int y){
        try{
            return x/y;
        }
        catch (ArithmeticException e){
            return 0;
        }
    }

    private static int divideLBYL(int x, int y){
        if(y != 0){
            return x/y;
        }else{
            return 0;
        }
    }

    private static int divide(int x, int y){
        return x/y;
    }
}
