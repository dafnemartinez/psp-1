package UT2_Multihilo;

public class P04_Productor implements Runnable {

	private P04_Buffer<Integer> buffer;
	boolean interrupted=false;
	
	public P04_Productor(P04_Buffer<Integer> b) {
		buffer=b;
	}
	
	public void interrupt() {
		interrupted=true;
	}
	
	public void run() {
		int n;
		while (!interrupted) {
			n=(int)(Math.random()*10000);
			buffer.set(n);
			System.out.println(Thread.currentThread().getName()+" inserta "+n);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {};
		}
	}
}
