package modernjava;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.IntStream;
import static java.util.Map.entry;

public class Practice {
	public static void main(String[] args) {
		Map<String,String> favouriteMovies = Map.ofEntries(entry("Raphael","Star Wars"),entry("Cristina","Matrix"),entry("Olivia","James Bond"));
		
		favouriteMovies.entrySet().stream().sorted(Entry.comparingByKey()).forEachOrdered(System.out::println);
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
