package ch14;

public class TakeTransTEst {

	public static void main(String[] args) {
	
		Student studentJ = new Student("James", 5000);
		Student studentT = new Student("Tomas", 5000);
		Student studentE = new Student("Edward", 20000);
		
		Bus bus100 = new Bus(100);
		Bus bus500 = new Bus(500);
		studentJ.takeBus(bus100);
		
		Subway greenSubway = new Subway(2);
		studentT.takeSubway(greenSubway);
		
		studentJ.showInfo();
		studentT.showInfo();
		
		bus100.showBusInfo();
		greenSubway.showSubwayInfo();
		
		bus500.showBusInfo();
		
		Taxi goodTaxi = new Taxi("잘 간다");
		studentE.takeTaxi(goodTaxi);
		
		goodTaxi.showInfo();
		studentE.showInfo();
	}

}
