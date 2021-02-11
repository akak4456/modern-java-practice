package modernjava;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


public class Practice {
	public static void main(String[] args) {
		 Trader raoul = new Trader("Raoul", "Cambridge");
		    Trader mario = new Trader("Mario", "Milan");
		    Trader alan = new Trader("Alan", "Cambridge");
		    Trader brian = new Trader("Brian", "Cambridge");

		    List<Transaction> transactions = Arrays.asList(
		        new Transaction(brian, 2011, 300),
		        new Transaction(raoul, 2012, 1000),
		        new Transaction(raoul, 2011, 400),
		        new Transaction(mario, 2012, 710),
		        new Transaction(mario, 2012, 700),
		        new Transaction(alan, 2012, 950)
		    );
		    
		    List<Transaction> q1 = transactions.stream().filter(t->t.getYear() == 2011).sorted(comparing(Transaction::getValue)).collect(toList());
		    System.out.println(q1);
		    
		    List<String> q2 = transactions.stream().map(t->t.getTrader().getCity()).distinct().collect(toList());
		    System.out.println(q2);
		    
		    List<Trader> q3 = transactions.stream()
		    							.map(Transaction::getTrader)
		    							.filter(trader -> trader.getCity().equals("Cambridge"))
		    							.distinct()
		    							.sorted(comparing(Trader::getName))
		    							.collect(toList());
		    System.out.println(q3);
		    
		    String q4 = transactions.stream()
		    								.map(t->t.getTrader().getName())
		    								.distinct()
		    								.sorted(String::compareTo)
		    								.reduce("",(n1,n2)->n1+n2);
		    System.out.println(q4);
		    boolean q5 = transactions.stream()
		    								.anyMatch(t->t.getTrader().getCity().equals("Milan"));
		    System.out.println(q5);
		    
		    transactions.stream()
		    								.filter(t->t.getTrader().getCity().equals("Cambridge"))
		    								.map(Transaction::getValue)
		    								.forEach(System.out::println);
		    
		    Optional<Integer> maxVal = transactions.stream()
		    					.map(Transaction::getValue)
		    					.reduce(Integer::max);
		    System.out.println(maxVal.get());
		    
		    Optional<Transaction> minVal = transactions.stream()
					.reduce((t1,t2)->t1.getValue() < t2.getValue() ? t1:t2);
System.out.println(minVal.get().getValue());
	}

}
