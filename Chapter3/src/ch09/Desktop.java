package ch09;

public class Desktop extends Computer {

	@Override
	public void display() {
		System.out.println("Desktop display");
	}

	@Override
	public void typing() {
		System.out.println("Desktop typing2");
	}

	@Override
	public void turnOn() {
		System.out.println("Desktop turnOn");
	}

	@Override
	public void turnOff() {
		System.out.println("Desktop turnOff");
	}
	

	
}
