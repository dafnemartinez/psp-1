package UT2_Multihilo;

import java.util.concurrent.BlockingQueue;

public class P05_Consumidor implements Runnable {

	private BlockingQueue<Integer> queue = null;

	public P05_Consumidor(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	public void run() {
		try {
			while (true)
				consumir(queue.take());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	void consumir(Object x) {
		System.out.println("Consumido "+x);
	}
}


