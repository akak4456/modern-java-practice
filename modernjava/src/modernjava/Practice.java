package modernjava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Practice {
	public static void main(String[] args) {
		List<Apple> inventory = Arrays.asList(
		        new Apple(80, "green"),
		        new Apple(155, "green"),
		        new Apple(120, "red")
		    );
		
		//List<Apple> greenApple = filterGreenApples(inventory);
		List<Apple> greenApple = filterApples(inventory,Practice::isGreenApple);
		System.out.println(greenApple);
		
		//List<Apple> heavyApple = filterHeavyApples(inventory);
		List<Apple> heavyApple = filterApples(inventory,Practice::isHeavyApple);
		System.out.println(heavyApple);
	}
	
	public static List<Apple> filterGreenApples(List<Apple> inventory){
		List<Apple> result = new ArrayList<>();
		
		for(Apple apple:inventory) {
			if("green".equals(apple.getColor())) {
				result.add(apple);
			}
		}
		return result;
	}
	
	public static List<Apple> filterHeavyApples(List<Apple> inventory){
		List<Apple> result = new ArrayList<>();
		
		for(Apple apple:inventory) {
			if(apple.getWeight() > 150) {
				result.add(apple);
			}
		}
		return result;
	}
	
	public static boolean isGreenApple(Apple apple) {
		return "green".equals(apple.getColor());
	}
	public static boolean isHeavyApple(Apple apple) {
		return apple.getWeight() > 150;
	}
	static List<Apple> filterApples(List<Apple> inventory,Predicate<Apple> p){
		List<Apple> result = new ArrayList<>();
		for(Apple apple: inventory) {
			if(p.test(apple)) {
				result.add(apple);
			}
		}
		return result;
	}
}
