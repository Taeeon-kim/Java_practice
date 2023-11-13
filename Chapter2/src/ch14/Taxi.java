package ch14;

public class Taxi {
	String taxName;
	int money;
	
	public Taxi(String taxName) {
		this.taxName = taxName;
	}
	
	public void take(int money) {
		this.money += money;
	}
	
	public void showInfo() {
		System.out.println(taxName + "운수택시 수입은 " + money + "입니다.");
	}
}
