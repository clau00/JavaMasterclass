package Concurency.Threads.ProducerConsumer;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static Concurency.Threads.ProducerConsumer.Main.EOF;

public class Main {
    public static final String EOF = "EOF";

    public static void main(String[] args) {
        List<String> buffer = new ArrayList<>();
        MyProducer producer = new MyProducer(buffer, ThreadColor.ANSI_GREEN);
        MyConsumer consumer1 = new MyConsumer(buffer, ThreadColor.ANSI_PURPLE);
        MyConsumer consumer2 = new MyConsumer(buffer, ThreadColor.ANSI_CYAN);

        new Thread(producer).start();
        new Thread(consumer1).start();
        new Thread(consumer2).start();
    }
}

class MyProducer implements Runnable {
    private List<String> buffer;
    private String color;

    public MyProducer(List<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    @Override
    public void run() {
        Random random = new Random();
        String[] nums = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15" };

        for(String num : nums) {
            try {
                System.out.println(color + "Adding..." + num);
                synchronized (buffer){
                    buffer.add(num);
                }

                Thread.sleep(random.nextInt(1000));
                System.out.println(color + "Producer asleep");
            } catch(InterruptedException e) {
                System.out.println(color + "Producer was interrupted");
            }
        }
        System.out.println(color + "Adding EOF and exiting...");
        synchronized (buffer){
            buffer.add("EOF");
        }
    }
}

class MyConsumer implements Runnable {
    private List<String> buffer;
    private String color;

    public MyConsumer(List<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    @Override
    public void run() {
        while(true) {
            synchronized (buffer){
                if(buffer.isEmpty()){
//                    System.out.println(color + "Consumer: buffer empty");
                    continue;
                }
                if(buffer.get(0).equals(EOF)) {
                    System.out.println(color + "Exiting...");
                    break;
                } else {
                    System.out.println(color + "Removed " + buffer.get(0));
                    buffer.remove(0);
                }
            }
        }
    }
}


