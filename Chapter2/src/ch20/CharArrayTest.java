package ch20;

public class CharArrayTest {

	public static void main(String[] args) {
	
		char[] alphabets = new char[26];
		char ch = 'A';
		
		for(int i=0; i<alphabets.length ; i++) {
			alphabets[i] = ch++;
		}
		
		for(char ch2 : alphabets) {
			System.out.println(ch2 +", " + (int)ch2);
		}

	}

}
