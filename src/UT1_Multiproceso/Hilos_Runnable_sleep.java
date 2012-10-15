package UT1_Multiproceso;

public class Hilos_Runnable_sleep implements Runnable {

    public void run() {
        System.out.println("Nuevo hilo");
        for (int i=1; i<20; i++)
        {
        	System.out.print(i+", ");
        	try
        	{
        		if (i%4==0)
        			Thread.sleep(4000,200); //secs, nsecs
        	}
        	catch (InterruptedException e)
        	{
        		System.out.println(e.getMessage());
        	}
        }
    }

    public static void main(String args[]) throws InterruptedException {
    for (int i=1; i<=5; i++)
        (new Thread(new Hilos_Runnable_sleep())).start();
    }
}
