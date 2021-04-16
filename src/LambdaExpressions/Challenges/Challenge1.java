package LambdaExpressions.Challenges;

public class Challenge1 {

    public static void main(String[] args) {

        //  Transform the below anonymous Runnable into a lambda
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                String myString = "Let's split this up into an array";
                String[] parts = myString.split(" ");
                for(String part : parts){
                    System.out.println(part);
                }
                System.out.println("======================= \n");
            }
        };

        new Thread(runnable).start();

        //  Result
        Runnable runnableLambda = () -> {
            String myString = "Let's split this up into an array";
            String[] parts = myString.split(" ");
            for(String part : parts){
                System.out.println(part);
            }
            System.out.println("======================= \n");
        };

        new Thread(runnableLambda).start();
    }
}

