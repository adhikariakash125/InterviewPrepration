package Java.Java8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8Streams2 {
    public static void main(String[] args) {
        //    1. Merge two lists of integers and remove duplicates using streams.
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list2 = Arrays.asList(4, 5, 6, 7, 8);
        List<Integer> integerList2 = Stream.concat(list1.stream(), list2.stream()).distinct().collect(Collectors.toList());
        System.out.println(integerList2);
//    2. Filter a list of numbers to only include those greater than 10 and then find their average.
        List<Integer> numbers = Arrays.asList(5, 12, 15, 8, 20, 3, 11);
        OptionalDouble average = numbers.stream().filter(x -> x > 10).mapToInt(x -> x).average();
//        average.ifPresent(System.out::println);
//    3. Partition a list of integers into even and odd numbers using streams.
        Map<Boolean, List<Integer>> listMap = numbers.stream().collect(Collectors.partitioningBy(x -> x % 2 == 0));
//        System.out.println(listMap);
//    4. Collect all unique words from a list of sentences using streams.
        List<String> sentences = Arrays.asList(
                "Java is a programming language",
                "Java is widely used",
                "Python is also a programming language",
                "Java and Python are popular languages"
        );
        Set<String> uniqueStrings = sentences.stream().flatMap(s -> Arrays.stream(s.split(" ")))
                .map(String::toLowerCase)
                .collect(Collectors.toSet());
//        System.out.println(uniqueStrings);
//    5. Flatten a list of lists of integers into a single list of integers using streams.
        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8)
        );
        List<Integer> integerList = listOfLists.stream().flatMap(List::stream).collect(Collectors.toList());
//        System.out.println(integerList);
//    6. Convert a list of strings to a map where the key is the string and the value is the length
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date");
        Map<String, Integer> collect = words.stream().collect(Collectors.toMap(Function.identity(), String::length));
//        System.out.println(collect);
//    7. Create a stream pipeline to group a list of strings by their length.
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve", "Frank");
        Map<Integer, List<String>> collect1 = names.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(collect1);
//    8. Convert a list of strings to a list of their respective lengths using streams.
        List<Integer> integerList1 = words.stream().map(String::length).collect(Collectors.toList());
        System.out.println(integerList1);
//    9. Count the number of occurrences of each character in a string using streams.
        String s = "Akash";
        Map<Character, Long> collect2 = s.chars()
                .mapToObj(x -> (char) x)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect2);
//    10. Find the product of all elements in a list of integers using streams
        List<Integer> numbersList = Arrays.asList(1, 2, 3, 4, 5);
        Integer reduce = numbersList.stream().reduce(1, (a, b) -> a * b);
        System.out.println(reduce);

    }
}
