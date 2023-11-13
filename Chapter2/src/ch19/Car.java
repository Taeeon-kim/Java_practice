package ch19;

public class Car {
	private static int carSerialNum = 1000;
	private int carNum;
	
	public Car() {
		carSerialNum++;
		carNum = carSerialNum;
	}
	
	public int getCarNum() {
		return carNum;
	}
}
