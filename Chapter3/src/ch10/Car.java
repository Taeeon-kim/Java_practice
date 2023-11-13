package ch10;

public abstract class Car {
	
	public abstract void drive(); // 추상 메서드 
	public abstract void stop();
	public abstract void wiper();
	
	
	public void startCar() {
		System.out.println("시동을 겁니다.");
	}
	
	public void turnOff() {
		System.out.println("시동을 끕니다.");
	}
	
	public void washCar() { // Hook 메서드
		
	}
	
	final public void run() { // 템플릿 메서드 
		startCar();
		drive();
		wiper();
		stop();
		turnOff();
		washCar();
	}
	
	
}
