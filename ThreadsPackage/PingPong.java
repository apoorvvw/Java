package ThreadsPackage;

public class PingPong implements Runnable
{
	/**
	 * @param args
	 */
	public void run()
	{
		// TODO Auto-generated method stub
		Thread tCurrent = Thread.currentThread();
		System.out.print(tCurrent+" ");
		if (tCurrent.getName().equals("ping"))
		{
				System.out.print("PING ");
		}
		if (tCurrent.getName().equals("pong"))
		{
			System.out.print("PONG ");
		}
//		try {
//			Thread.sleep(500);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		ThreadGroup grp=new ThreadGroup("mygroup");
		Thread t1=new Thread(grp,new PingPong());
		Thread t2=new Thread(grp,new PingPong());
		t1.setName("ping");
		t2.setName("pong");
		t1.start();
		t2.start();
		grp.interrupt();
		System.out.println("Mains ends ");
	}

}
