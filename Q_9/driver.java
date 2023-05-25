package Q_9;

public class driver {

	public static void main(String[] args) throws Exception{

		process1 ob1=new process1();
		process2 ob2=new process2();
		ob1.start();
		
			Thread.sleep(5000);
		
		ob2.start();
	}

}
