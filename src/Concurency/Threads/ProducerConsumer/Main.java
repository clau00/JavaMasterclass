package Concurency.Threads.ProducerConsumer;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

import static Concurency.Threads.ProducerConsumer.Main.EOF;

public class Main {
    public static final String EOF = "EOF";

    public static void main(String[] args) {
        ArrayBlockingQueue<String> buffer = new ArrayBlockingQueue<String>(6);

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        MyProducer producer = new MyProducer(buffer, ThreadColor.ANSI_GREEN);
        MyConsumer consumer1 = new MyConsumer(buffer, ThreadColor.ANSI_PURPLE);
        MyConsumer consumer2 = new MyConsumer(buffer, ThreadColor.ANSI_CYAN);

        executorService.execute(producer);
        executorService.execute(consumer1);
        executorService.execute(consumer2);

        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println(ThreadColor.ANSI_GREEN + "I'm being printed from the Callable class");
                return "This is the callable result";
            }
        });

        executorService.shutdown();
    }
}

class MyProducer implements Runnable {
    private ArrayBlockingQueue<String> buffer;
    private String color;

    public MyProducer(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    @Override
    public void run() {
        Random random = new Random();
        String[] nums = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };

        for(String num : nums) {
            try {
                System.out.println(color + "Adding..." + num);
                buffer.put(num);

                Thread.sleep(random.nextInt(1000));
                System.out.println(color + "Producer asleep");
            } catch(InterruptedException e) {
                System.out.println(color + "Producer was interrupted");
            }
        }
        System.out.println(color + "Adding EOF and exiting...");
        try {
            buffer.put("EOF");
        } catch (InterruptedException e) {

        }
    }
}

class MyConsumer implements Runnable {
    private ArrayBlockingQueue<String> buffer;
    private String color;

    public MyConsumer(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    @Override
    public void run() {

        while (true) {
            synchronized (buffer){
                try {
                    if (buffer.isEmpty()) {
//                    System.out.println(color + "Consumer: buffer empty");
                        continue;
                    }
                    if (buffer.peek().equals(EOF)) {
                        System.out.println(color + "Exiting...");
                        break;
                    } else {
                        System.out.println(color + "Removed " + buffer.take());
                    }
                } catch (InterruptedException e) {

                }
            }

        }
    }
}


