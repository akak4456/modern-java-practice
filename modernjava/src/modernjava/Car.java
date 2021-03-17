package modernjava;

import java.util.Optional;

public class Car {
	private Optional<Insurance> insurance;
	public Car() {
		this.insurance = Optional.empty();
	}
	public Car(Optional<Insurance> insurance) {
		this.insurance = insurance;
	}
	public Optional<Insurance> getInsurance() {return insurance;}
}
