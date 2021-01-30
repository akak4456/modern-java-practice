package modernjava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Practice {
	public static void main(String[] args) {
		List<Apple> inventory = Arrays.asList(
		        new Apple(80, Color.GREEN),
		        new Apple(155, Color.GREEN),
		        new Apple(120, Color.RED)
		    );
		inventory.sort((Apple a1,Apple a2)->a1.getWeight().compareTo(a2.getWeight()));
		System.out.println(inventory);
	}
	
	public static List<Apple> filterApplesByColor(List<Apple> inventory,Color color){
		List<Apple> result = new ArrayList<>();
		for(Apple apple:inventory) {
			if(apple.getColor().equals(color)) {
				result.add(apple);
			}
		}
		return result;
	}
	
	public static List<Apple> filterApplesByWeight(List<Apple> inventory,int weight){
		List<Apple> result = new ArrayList<>();
		for(Apple apple:inventory) {
			if(apple.getWeight() > weight) {
				result.add(apple);
			}
		}
		return result;
	}
	
	public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p){
		List<Apple> result = new ArrayList<>();
		for(Apple apple:inventory) {
			if(p.test(apple)) {
				result.add(apple);
			}
		}
		return result;
	}
	
	public static void prettyPrintApple(List<Apple> inventory, AppleFormatter formatter) {
		for(Apple apple:inventory) {
			String output = formatter.accept(apple);
			System.out.println(output);
		}
	}
}
