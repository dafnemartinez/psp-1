package UT2_Multihilo;

public class E06_interrupt implements Runnable {
	private static final long segundos=86400;
    public void run() {
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
    	final long segundos=5;
    	Thread [] t=new Thread[5];

    	for (int i=0; i<t.length; i++) {
    		t[i]=new Thread(new E06_interrupt());
    		t[i].start();
    	}
    	System.out.println("Os dejo dormir "+segundos+" segundos, hilos mios...");
    	Thread.sleep(segundos*1000);
    	System.out.println("Se acabó el descanso!");
    	for (int i=0; i<t.length; i++)
    		t[i].interrupt();
    }
}
