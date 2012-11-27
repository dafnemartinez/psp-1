package UT2_Multihilo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

	public class P05_BlockingQueueExample {

	    public static void main(String[] args) throws Exception {

			BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(1024);

	        P05_Productor producer = new P05_Productor(queue);
	        P05_Consumidor consumer = new P05_Consumidor(queue);

	        new Thread(producer).start();
	        new Thread(consumer).start();

	        Thread.sleep(4000);
	    }
	}
