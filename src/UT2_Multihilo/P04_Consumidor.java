package UT2_Multihilo;

public class P04_Consumidor implements Runnable {

	private P04_Buffer<Integer> buffer;
	boolean interrupted=false;
	
	public P04_Consumidor(P04_Buffer<Integer> b) {
		buffer=b;
	}
	
	public void interrupt() {
		interrupted=true;
	}
		
	public void run() {
		int n;
		while (!interrupted) {
			n=buffer.get();
			System.out.println(Thread.currentThread().getName()+" obtiene "+n);
		}
	}
}
