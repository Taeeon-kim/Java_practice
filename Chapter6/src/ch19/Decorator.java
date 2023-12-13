package ch19;

public abstract class Decorator extends Coffee {
	
	Coffee coffee;
	
	public Decorator(Coffee coffee) {
		this.coffee = coffee;
	}
	
	@Override
	public void brewing() {
		// TODO Auto-generated method stub
		coffee.brewing();
	}
	
}
