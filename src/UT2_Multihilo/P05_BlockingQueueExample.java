package UT2_Multihilo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

	//Ejemplo de uso de objetos concurrentes: ArrayBlockingQueue
	//
	//Observa la sencillez de la implementación, sin sinchronized ni wair/notify

	public class P05_BlockingQueueExample {

	    public static void main(String[] args) throws Exception {

			BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(1024);

	        P05_Productor producer1 = new P05_Productor(queue);
	        P05_Productor producer2 = new P05_Productor(queue);
	        P05_Consumidor consumer = new P05_Consumidor(queue);

	        new Thread(producer1).start();
	        new Thread(producer2).start();
	        new Thread(consumer).start();

	        Thread.sleep(4000);
	    }
	}
