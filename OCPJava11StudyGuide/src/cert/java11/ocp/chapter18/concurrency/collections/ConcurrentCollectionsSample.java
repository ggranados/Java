package cert.java11.ocp.chapter18.concurrency.collections;

import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class    ConcurrentCollectionsSample {
    public static void main(String[] args) {

        // ConcurrentHashMap
        var foodData = new ConcurrentHashMap<String, Integer>();
        foodData.put("penguin", 1);
        foodData.put("flamingo", 2);
        for(String key: foodData.keySet())
            foodData.remove(key);

        // ConcurrentHashMap
        Map<String,Integer> map = new ConcurrentHashMap<>();
        map.put("zebra", 52);
        map.put("elephant", 10);
        System.out.println(map.get("elephant"));  // 10

        // ConcurrentLinkedQueue
        Queue<Integer> queue = new ConcurrentLinkedQueue<>();
        queue.offer(31);
        System.out.println(queue.peek());  // 31
        System.out.println(queue.poll());  // 31

        // ConcurrentSkipListSet
        Set<String> gardenAnimals = new ConcurrentSkipListSet<>();
        gardenAnimals.add("rabbit");
        gardenAnimals.add("gopher");
        System.out.println(gardenAnimals.stream()
                .collect(Collectors.joining(",")));  // gopher,rabbit

        // ConcurrentSkipListMap
        Map<String, String> rainForestAnimalDiet
                = new ConcurrentSkipListMap<>();
        rainForestAnimalDiet.put("koala", "bamboo");
        rainForestAnimalDiet.entrySet()
                .stream()
                .forEach((e) -> System.out.println(
                        e.getKey() + "-" + e.getValue())); // koala-bamboo

        // CopyOnWriteArrayList
        List<Integer> favNumbers =
                new CopyOnWriteArrayList<>(List.of(4,3,42));
        for(var n: favNumbers) {
            System.out.print(n + " ");
            favNumbers.add(9);
        }
        System.out.println();
        System.out.println("Size: " + favNumbers.size());

        // CopyOnWriteArraySet
        Set<Character> favLetters =
                new CopyOnWriteArraySet<>(List.of('a','t'));
        for(char c: favLetters) {
            System.out.print(c+" ");
            favLetters.add('s');
        }
        System.out.println();
        System.out.println("Size: "+ favLetters.size());

        // delete while iterating with CopyOnWriteArrayList
        List<String> birds = new CopyOnWriteArrayList<>();
        birds.add("hawk");
        birds.add("hawk");
        birds.add("hawk");

        for (String bird : birds)
            birds.remove(bird);
        System.out.print(birds.size()); // 0


    }
}
