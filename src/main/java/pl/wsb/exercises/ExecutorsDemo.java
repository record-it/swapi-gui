package pl.wsb.exercises;

import java.util.Scanner;
import java.util.concurrent.*;

public class ExecutorsDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(5);
        scheduler.scheduleAtFixedRate(() -> {
            System.out.println("TICK START");
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("TICK END");
        }, 1000, 1000, TimeUnit.MILLISECONDS);


    }
}
