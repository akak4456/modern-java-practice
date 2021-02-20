package modernjava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class PrimeNumbersCollector implements Collector<Integer, Map<Boolean,List<Integer>>, Map<Boolean,List<Integer>>> {

	@Override
	public Supplier<Map<Boolean, List<Integer>>> supplier() {
		/*
		 * return () ->{ Map<Boolean,List<Integer>> map = new HashMap<>(); map.put(true,
		 * new ArrayList<Integer>()); map.put(false, new ArrayList<Integer>()); return
		 * map; };
		 */
		
		return ()-> new HashMap<Boolean,List<Integer>>(){{ put(true,new
		ArrayList<Integer>()); put(false,new ArrayList<Integer>()); }};
		 
	}

	@Override
	public BiConsumer<Map<Boolean, List<Integer>>, Integer> accumulator() {
		return (Map<Boolean,List<Integer>> acc,Integer candidate) ->{
			acc.get(Practice.isPrime(acc.get(true),candidate)).add(candidate);
		};
	}

	@Override
	public BinaryOperator<Map<Boolean, List<Integer>>> combiner() {
		return null;
	}

	@Override
	public Function<Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> finisher() {
		return Function.identity();
	}

	@Override
	public Set<Characteristics> characteristics() {
		return Collections.unmodifiableSet(EnumSet.of(Collector.Characteristics.IDENTITY_FINISH));
	}

}
