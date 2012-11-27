package UT2_Multihilo;

import java.util.concurrent.BlockingQueue;

public class P05_Productor implements Runnable{

	private BlockingQueue<Integer> queue = null;

	public P05_Productor(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	public void run() {
		try {
			while (true) {
				Integer n;
				queue.put(n=producir());
				Thread.sleep(500);
				System.out.println("Producido "+n);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
    Integer producir() {
		Integer n=new Integer((int)(Math.random()*10000));
		return n;
    }
}
