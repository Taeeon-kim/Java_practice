package ch14;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int i;
		try(FileInputStream fis = new FileInputStream("input.txt")){
			
			while( (i= fis.read()) != -1){
				System.out.print((char)i);
			}
			
		}catch(IOException e) {
			System.out.println(e);
		}
	}

}
