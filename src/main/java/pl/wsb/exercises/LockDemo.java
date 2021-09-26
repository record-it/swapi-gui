package pl.wsb.exercises;

import java.util.Collections;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ClipLock{
    private Lock lock = new ReentrantLock();
    private Random random = new Random();
    public void clip() throws InterruptedException {
        Thread.sleep(random.nextInt(100));
        if (lock.tryLock()){
            System.out.println("LOCKED");
            lock.unlock();
        };
    }
}
public class LockDemo {
    public static void main(String[] args) {
        ClipLock clipLock = new ClipLock();
        for (int i = 0; i < 10; i++){
            new Thread(() -> {
                try {
                    clipLock.clip();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();

            ExecutorService service = Executors.newFixedThreadPool(5);

            Queue<String> queue = new LinkedBlockingQueue<>();
            queue.add("AAA");
            queue.add("CED");
            queue.add("RET");

        }
    }
}
