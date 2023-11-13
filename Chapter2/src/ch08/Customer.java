package ch08;

public class Customer {
	public String customerName;
	public int weight;
	public int age;
	public int height;
	public String sex;
 public Customer() {}
 public Customer(
		 String customerName, 
		 int weight, 
		 int age, 
		 int height, 
		 String sex) {
	 this.customerName = customerName;
	 this.age = age;
	 this.height = height;
	 this.sex = sex;
	 this.weight = weight;
 }
 
 public String showCustomerInfo() {
	 return "키가 "+ height + "이고 몸무게가 " + weight + 
			 "킬로인 "+ sex + "이 있습니다. 이름은 " + customerName 
			 + "이고 나이는 " + age + "입니다.";
 }
}
