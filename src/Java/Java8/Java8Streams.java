package Java.Java8;

import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Java8Streams {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee(1, "Alice Johnson", 75000),
                new Employee(2, "Bob Smith", 62000),
                new Employee(3, "Charlie Brown", 85000),
                new Employee(4, "Diana Prince", 95000),
                new Employee(5, "Ethan Hunt", 72000),
                new Employee(6, "Fiona Green", 80000),
                new Employee(7, "George White", 67000),
                new Employee(8, "Hannah Blue", 90000),
                new Employee(9, "Ian Gray", 64000),
                new Employee(10, "Julia Black", 88000)
        );

//        1. Find the employee with the highest salary from a list of employee objects using streams.
        Optional<Employee> first = employees.stream().sorted((a, b) -> (int) (b.getSalary() - a.getSalary())).findFirst();
//        System.out.println(first);
        
//        2. Concatenate a list of strings into a single string, separated by commas, using streams.
        List<String> strings = Arrays.asList("Apple", "Banana", "Cherry", "Date", "Elderberry");
        String collect = strings.stream().collect(Collectors.joining());
//        System.out.println(collect);

//        3. Find the first non-repeating character in a string using streams.
        String val = "swiss";
        Character c = val.chars().mapToObj(x -> (char) x).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(x -> x.getValue() == 1)
                .map(x -> x.getKey())
                .findFirst()
                .orElse(null);
//        System.out.println(c);

//        4. Filter out movies of a specific genre and collect them into a set using streams.
        List<Film> filmList = Arrays.asList(
                new Film("Despicable Me", "Animation", "better.", 7.7),
                new Film("The Martian", "Adventure", "alive.", 8.0),
                new Film("Ted", "Comedy", "Lori.", 6.9),
                new Film("Alita", "Adventure", "is.", 7.6),
                new Film("Girl", "Drama", "ballerina.", 7.2),
                new Film("A Star Is Born", "Romance", "spiral.", 7.9)
        );
        Set<Film> animation = filmList.stream().filter(film -> film.getGenre().equals("Adventure")).collect(Collectors.toSet());
//        System.out.println(animation);


//        5. Find the first name of the oldest person in a list of Person objects using streams.
        List<Person> people = Arrays.asList(
                new Person("Augusta Ada King", 1815),
                new Person("Muhammad ibn Musa al-Khwarizmi", 780),
                new Person("Alan Turing", 1912),
                new Person("Grace Hopper", 1906)
        );
        Optional<Person> first1 = people.stream()
                .sorted((a, b) -> b.getAge(LocalDateTime.now().getYear()) - a.getAge(LocalDateTime.now().getYear()))
                .findFirst();
//        first1.ifPresent(x -> System.out.println(x.getName()));
//        6. Filter out null values from a list of strings using streams.
        List<String> langs = Arrays.asList("Java", "Python", null, "C++", null, "JavaScript");
        List<String> stringList = langs.stream().filter(x -> x != null).collect(Collectors.toList());
//        System.out.println(stringList);

//        7. Find the sum of the squares of a list of integers using streams.
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Integer reduce = numbers.stream().map(x -> x * x).reduce(0, Integer::sum);
//        System.out.println(reduce);
//        8. Skip the first 7 elements in a list and then. print the rest using streams.
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
//        integers.stream().skip(7).forEach(System.out::println);

//       TODO:  9. Generate an infinite sequence of random numbers and print the first 10 using streams.

//        10. Check if any string in a list starts with a specific prefix using streams.
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve");
        names.stream().filter(x -> x.startsWith("C")).forEach(System.out::println);


    }
}
