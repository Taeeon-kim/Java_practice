package ch06;

public class StudentTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student studentLee = new Student();
		System.out.println(studentLee.showStudentInfo());
		
		Student studentKim = new Student(123456, "덕배", 3);
		System.out.println(studentKim.showStudentInfo());
	}

}
