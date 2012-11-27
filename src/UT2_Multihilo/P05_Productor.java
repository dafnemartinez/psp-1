package UT2_Multihilo;

import java.util.concurrent.BlockingQueue;

public class P05_Productor implements Runnable{

	protected BlockingQueue<Integer> queue = null;

	public P05_Productor(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	public void run() {
		try {
			queue.put(1);
			Thread.sleep(1000);
			queue.put(2);
			Thread.sleep(1000);
			queue.put(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
