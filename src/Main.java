import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
            String s = "Akash";
        Character c = s.chars().mapToObj(x -> (char) x).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream().filter(x -> x.getValue() == 1)
                .map(x -> x.getKey())
                .findFirst()
                .orElse(null);

    }
}