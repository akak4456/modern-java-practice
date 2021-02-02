package modernjava;

import static java.util.Comparator.comparing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Practice {
	public static void main(String[] args) {
		List<Apple> inventory = Arrays.asList(new Apple(80, Color.GREEN, "KR"), new Apple(155, Color.GREEN, "KR"),
				new Apple(155, Color.GREEN, "EN"), new Apple(120, Color.RED, "FR"));
		inventory.sort(comparing(Apple::getWeight).reversed().thenComparing(Apple::getCountry));
		System.out.println(inventory);
		
		Function<Integer,Integer> f = x -> x+1;
		Function<Integer,Integer> g = x -> x*2;
		Function<Integer,Integer> h = f.compose(g);
		int result = h.apply(1);
		System.out.println(result);
	}

	public static List<Apple> filterApplesByColor(List<Apple> inventory, Color color) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if (apple.getColor().equals(color)) {
				result.add(apple);
			}
		}
		return result;
	}

	public static List<Apple> filterApplesByWeight(List<Apple> inventory, int weight) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if (apple.getWeight() > weight) {
				result.add(apple);
			}
		}
		return result;
	}

	public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if (p.test(apple)) {
				result.add(apple);
			}
		}
		return result;
	}

	public static void prettyPrintApple(List<Apple> inventory, AppleFormatter formatter) {
		for (Apple apple : inventory) {
			String output = formatter.accept(apple);
			System.out.println(output);
		}
	}
}
