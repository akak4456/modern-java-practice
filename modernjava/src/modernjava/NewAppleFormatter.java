package modernjava;

public class NewAppleFormatter implements AppleFormatter {

	@Override
	public String accept(Apple a) {
		// TODO Auto-generated method stub
		return a.toString()+"THIS IS NEW!!!";
	}

}
