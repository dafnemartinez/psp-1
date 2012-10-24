package UT2_Multihilo;

import java.util.Random;

public class Hilos05 implements Runnable {
    public void run() {
    	Random r=new Random();
    	int segundos=r.nextInt(10) + 1;
        System.out.println("Sueño: me voy a dormir "+segundos+" seg...");
        try {
        	Thread.sleep(segundos*1000);
        }
        catch (InterruptedException e)
        {
        	System.out.print("Me han despertado!");
        }
    }

    public static void main(String args[]) throws InterruptedException {
    	Thread [] t=new Thread[5];

    	for (int i=0; i<t.length; i++) {
    		t[i]=new Thread(new Hilos05());
    		t[i].start();
    	}
    	System.out.println("Esperando a que mis hilos terminen...");
    	for (int i=0; i<t.length; i++)
    		t[i].join();
    	System.out.println("Adiós!");
    }
}
