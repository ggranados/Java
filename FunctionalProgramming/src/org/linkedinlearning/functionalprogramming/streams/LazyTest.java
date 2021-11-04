package org.linkedinlearning.functionalprogramming.streams;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class LazyTest {
    public static void main(String[] args) {

        final Random random = new Random();

        Supplier<Integer> supplier = () -> {
          Integer result = random.nextInt();
          System.out.println("(supplying " + result + ")");
          return result;
        };

        System.out.println("\n Test 1");

        Stream<Integer> randoms = Stream.generate(supplier);

        System.out.println("First stream built");

        randoms.filter(n -> n >= 0).limit(3).forEach(System.out::println);


        System.out.println("\n Test 2");

        Stream<Integer> randoms2 = Stream.generate(supplier);

        randoms2.limit(3).filter(n -> n >= 0).forEach(System.out::println);

    }
}
