package modernjava;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class Practice {
	public static void main(String[] args) {
		List<Integer> numbers = List.of(1, 3, 7, 8, 10, 15, 4)
		        .stream()
		        .dropWhile(i -> i < 10)
		        .collect(toList());
		System.out.println(numbers);
	}

}
