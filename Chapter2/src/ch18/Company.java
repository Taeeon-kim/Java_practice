package ch18;

public class Company {
	
	private static Company instance = new Company(); // 유일한 instance Company 인스턴트
	
	private Company() { // private처리로 외부에서 생성자를 생성하지못하게한다.
		
	}
	
	public static Company getInstance() { // static 으로 선언하여 외부에서 클래스이름으로 호출가능 
		if(instance == null) {
			instance = new Company();
		}
		return instance;
	}
	
}
