package modernjava;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

public class ForkJoinSumCalculatorTest {

	public static void main(String[] args) {
		long[] numbers = LongStream.rangeClosed(1, 10).toArray();
		ForkJoinTask<Long> task = new ForkJoinSumCalculator(numbers);
		System.out.println(new ForkJoinPool().invoke(task));

	}

}
