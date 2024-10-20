package Misc;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.PriorityQueue;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GetMostFrequentElement {
    public static void main(String[] args) {
        int[] x = new int[]{4,3,1,2,3,1,4,2,3,3,5};
        LinkedHashMap<Integer, Integer> collect = Arrays.stream(x).boxed()
                .collect(Collectors.
                        groupingBy(Function.identity(), LinkedHashMap::new, Collectors.summingInt(value -> 1)));
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a,b) -> b[1]-a[1]);
        for (Integer i : collect.keySet()){
            priorityQueue.offer(new int[]{i,collect.get(i)});
        }
        System.out.println(priorityQueue.poll()[0]);
    }
}
