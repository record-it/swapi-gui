package pl.wsb.exercises;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.*;
import java.util.stream.*;

public class UnaryOperatorDemo {
    static int ticketSold;
    static AtomicInteger ticketTaken = new AtomicInteger(0);
    public static void main(String[] args) {
        String[] intMapper = {"ZERO", "Jeden", "dwA", "tRZy"};
        UnaryOperator<String> uniform = str -> str.toUpperCase(Locale.ROOT);
        System.out.println(uniform.andThen(str -> str.substring(2)).apply("RÓŻYCZKA"));
        BiPredicate<Integer, Integer> inRange = (index, length) -> index > -1 && index < length;
        Function<Integer, String> mapIntegersToWords = uniform.compose((Integer i) -> inRange.test(i, intMapper.length) ? intMapper[i]: "inna");
        System.out.println(mapIntegersToWords.apply(3));

        int number = 3;
        if (number > -1 && number < intMapper.length){
            System.out.println(intMapper[number].toLowerCase(Locale.ROOT));
        } else {
            System.out.println("inna".toUpperCase(Locale.ROOT));
        }
        System.out.println(Optional.ofNullable(null).isPresent());
        Stream<Integer> integers = Stream.of(1, 2, 4);

        IntStream.iterate(1, p -> p + 1)
                .parallel()
                .limit(100)
                .forEach(x -> ++ticketSold);
        IntStream.iterate(1, p -> p + 1)
                .parallel()
                .limit(100)
                .forEach(x -> ticketTaken.getAndIncrement());
        System.out.println();
        System.out.println(ticketSold);
        System.out.println(ticketTaken);
        Stream<Long> longStream = Stream.of(2L, 3L, 4L, 5L);
        DoubleStream doubleStream = DoubleStream.of(1, 2, 3, 4, 5);
        Deque<String> q = new ArrayDeque<>();
        q.add("LOLEK");
        Stream.of(Set.of("ALA"), List.of("KAROL","EWA"), q)
                .flatMap(x -> x.stream())
                .forEach(System.out::println);

        Map<Integer, List<String>> collect = List.of("A", "BE", "CD", "D").parallelStream().collect(Collectors.groupingBy(s -> s.length()));
        System.out.println(collect);
        var names = new ArrayList<String>(List.of("Adam","Ewa","Karol"));
        names.stream().map(String::toLowerCase).forEach(System.out::println);
        names.removeIf( s -> s.length() < 4);
        System.out.println(names);
        List<Integer> integers1 = List.of(5, 3, 5);
        float reduce = List.of(1, 3, 5).parallelStream().reduce(0f, (a, b) -> a.floatValue() + b.floatValue(), (c, d) -> c.floatValue() + d.floatValue());
        IntStream.iterate(0, p -> p+1).limit(20).dropWhile(x -> x < 10).forEach(System.out::print);
        System.out.println();
        ObjIntConsumer<String> con = (str, a) -> System.out.println(str.substring(a));
        con.accept("ALABASTER",3);
        Collection<String> s= List.of("g");
        var lol = "lol";
        var LOL = "LOL";
        var smiley = lol.toUpperCase() == lol;
        var smirk = "LOL" == LOL;
        System.out.println(smiley);
        System.out.println(smirk);
    }

    public static double  mine(BiFunction<Integer, Double, Double> func){
        func.apply(3, 5.0);
        long a = 2L;
        return a;
    }
}
