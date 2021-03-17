package modernjava;

import java.util.Optional;

public class Practice {

	public static void main(String[] args) {
		Person person = new Person();
		Optional<Person> optPerson = Optional.of(person);
		String name = optPerson.flatMap(Person::getCar).flatMap(Car::getInsurance).map(Insurance::getName).orElse("Unknown");
		System.out.println(name);
	}
	
}
