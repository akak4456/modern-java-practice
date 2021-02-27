package modernjava;

import java.util.Spliterator;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class WordCounterSpliteratorTest {
	public static final String SENTENCE =
		      " Nel   mezzo del cammin  di nostra  vita "
		      + "mi  ritrovai in una  selva oscura"
		      + " che la  dritta via era   smarrita ";
	public static void main(String[] args) {
	
		Spliterator<Character> spliterator = new WordCounterSpliterator(SENTENCE);
		Stream<Character> stream = StreamSupport.stream(spliterator, true);
		
		System.out.println(countWords(stream));
	
		
		Stream<Character> seq = IntStream.range(0, SENTENCE.length()).mapToObj(SENTENCE::charAt);
		
		System.out.println(countWords(seq));
		
		Stream<Character> wrong = IntStream.range(0, SENTENCE.length()).mapToObj(SENTENCE::charAt);
		
		System.out.println(countWords(wrong.parallel()));
	}
	
	private static int countWords(Stream<Character> stream) {
		WordCounter wordCounter = stream.reduce(new WordCounter(0,true),WordCounter::accumulate,WordCounter::combine);
		return wordCounter.getCounter();
	}

}
