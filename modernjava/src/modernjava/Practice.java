package modernjava;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.summarizingInt;
import static java.util.stream.Collectors.summingInt;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.filtering;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.collectingAndThen;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.IntStream;


public class Practice {
	public static void main(String[] args) {
		Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
		List<Dish> menu = asList(
			      new Dish("pork", false, 800, Dish.Type.MEAT),
			      new Dish("beef", false, 700, Dish.Type.MEAT),
			      new Dish("chicken", false, 400, Dish.Type.MEAT),
			      new Dish("french fries", true, 530, Dish.Type.OTHER),
			      new Dish("rice", true, 350, Dish.Type.OTHER),
			      new Dish("season fruit", true, 120, Dish.Type.OTHER),
			      new Dish("pizza", true, 550, Dish.Type.OTHER),
			      new Dish("prawns", false, 400, Dish.Type.FISH),
			      new Dish("salmon", false, 450, Dish.Type.FISH)
			  );
		Optional<Dish> mostCalorieDish = menu.stream().collect(maxBy(dishCaloriesComparator));
		
		System.out.println(mostCalorieDish.get());
		
		int totalCalories = menu.stream().collect(summingInt(Dish::getCalories));
		System.out.println(totalCalories);
		
		IntSummaryStatistics menuStatistics = menu.stream().collect(summarizingInt(Dish::getCalories));
		
		System.out.println(menuStatistics);
		
		String shortMenu = menu.stream().map(Dish::getName).collect(joining(", "));
		System.out.println(shortMenu);
		
		Map<Dish.Type,List<Dish>> dishesByType = menu.stream().collect(groupingBy(Dish::getType));
		
		System.out.println(dishesByType);
		
		Map<CaloricLevel,List<Dish>> dishesByCaloricLevel = menu.stream().collect(
				groupingBy(dish->{
					if(dish.getCalories() <= 400) return CaloricLevel.DIET;
					else if(dish.getCalories() <= 700) return CaloricLevel.NORMAL;
					else return CaloricLevel.FAT;
				})
		);
		System.out.println(dishesByCaloricLevel);
		
		Map<Dish.Type,List<Dish>> caloricDishesByType = menu.stream()
																.collect(groupingBy(Dish::getType,filtering(dish->dish.getCalories() > 500, toList())));
		System.out.println(caloricDishesByType);
		
		Map<Dish.Type,List<String>> dishNamesByType = menu.stream()
															.collect(groupingBy(Dish::getType,mapping(Dish::getName,toList())));
		System.out.println(dishNamesByType);
		
		Map<Dish.Type,Map<CaloricLevel,List<Dish>>> dishesByTypeCaloricLevel = menu.stream().collect(groupingBy(Dish::getType,groupingBy(dish->{
			if(dish.getCalories() <= 400)
				return CaloricLevel.DIET;
			else if(dish.getCalories() <= 700)
				return CaloricLevel.NORMAL;
			else return CaloricLevel.FAT;
		})));
		System.out.println(dishesByTypeCaloricLevel);
		
		Map<Dish.Type,Long> typesCount = menu.stream().collect(groupingBy(Dish::getType,counting()));
		
		System.out.println(typesCount);
		
		Map<Dish.Type,Optional<Dish>> mostCaloricByType = menu.stream().collect(groupingBy(Dish::getType,maxBy(Comparator.comparingInt(Dish::getCalories))));
		
		System.out.println(mostCaloricByType);
		
		Map<Boolean,List<Dish>> partitionedMenu = menu.stream().collect(partitioningBy(Dish::isVegetarian));
		System.out.println(partitionedMenu);
		
		Map<Boolean,Map<Dish.Type,List<Dish>>> vegetarianDishesByType = menu.stream().collect(partitioningBy(Dish::isVegetarian,groupingBy(Dish::getType)));
		System.out.println(vegetarianDishesByType);
		
		Map<Boolean,Dish> mostCaloricPartitionedByVegetarian = menu.stream().collect(partitioningBy(Dish::isVegetarian,collectingAndThen(maxBy(Comparator.comparingInt(Dish::getCalories)),Optional::get)));
		System.out.println(mostCaloricPartitionedByVegetarian);
		
		Map<Boolean,List<Integer>> partitionPrimes = IntStream.rangeClosed(2, 100).boxed().collect(partitioningBy(candidate->isPrime(candidate)));
		System.out.println(partitionPrimes);
		
		List<Dish> dishes = menu.stream().collect(new ToListCollector<Dish>());
		System.out.println(dishes);
		
		Map<Boolean,List<Integer>> partitionPrimes2 = IntStream.rangeClosed(2, 100).boxed().collect(new PrimeNumbersCollector());
		System.out.println(partitionPrimes2);
	}
	
	public static boolean isPrime(int candidate) {
		int candidateRoot = (int) Math.sqrt((double)candidate);
		return IntStream.rangeClosed(2, candidateRoot).noneMatch(i->candidate%i == 0);
	}
	
	public static boolean isPrime(List<Integer> primes, int candidate) {
		int candidateRoot = (int) Math.sqrt((double)candidate);
		return primes.stream().takeWhile(i -> i<= candidateRoot).noneMatch(i->candidate%i == 0);
	}

}
