package pl.wsb.exercises;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
public class CollectionDemo {
    public static int sum(int[] arr, int current){
        System.out.println("Recursion call " + current);
        if (current  >= arr.length || current < 0){
            return 0;
        }
        return arr[current] + sum(arr, current + 1);
    }

    public static int tailSum(int []arr, int current, int accu){
        System.out.println("Recursion call " + current);
        if (current  >= arr.length || current < 0){
            return accu;
        }
        return tailSum(arr, current + 1, accu + arr[current]);
    }
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> copy = new CopyOnWriteArrayList<>(List.of("ADAM", "ELA", "KAROL"));
        copy.add("ALA");
        Iterator<String> iterator = copy.iterator();
        while(iterator.hasNext()) {
            String item = iterator.next();
            if (item.length() == 3){
                iterator.remove();
            }
        }
        System.out.println(copy);
    }
}
