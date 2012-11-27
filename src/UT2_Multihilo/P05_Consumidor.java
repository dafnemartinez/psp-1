package UT2_Multihilo;

import java.util.concurrent.BlockingQueue;

public class P05_Consumidor implements Runnable {

	protected BlockingQueue<Integer> queue = null;

	public P05_Consumidor(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	public void run() {
		try {
			System.out.println(queue.take());
			System.out.println(queue.take());
			System.out.println(queue.take());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}