package ch08;

public class AutoCloseableObj implements AutoCloseable {

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("closing....");
	}

}
