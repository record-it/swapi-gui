package pl.wsb.exercises;
import java.util.NavigableSet;
import java.util.concurrent.*;

public class TpsReport {
    public void submitReports() throws ExecutionException, InterruptedException {
        var s = Executors.newCachedThreadPool();
        Future bosses = s.submit(() ->
                System.out.print("1"));
        s.shutdown();
        System.out.print(bosses.get());
         }
 public static void main(String[] memo) throws ExecutionException, InterruptedException {
        new TpsReport().submitReports();
     NavigableSet<String> strings = new ConcurrentSkipListSet<>();
     strings.add("KOLA");
     strings.add("PAUL");
     strings.add("ADAM");
     System.out.println(strings);

 }
}
