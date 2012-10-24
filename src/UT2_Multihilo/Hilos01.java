package UT2_Multihilo;

public class Hilos01 extends Thread {
//Forma NO recomendada de crear un hilo
//Problema: la clase no puede derivarse de otra, solamente de Thread
    public void run() {
    	Thread esteHilo=Thread.currentThread();
        System.out.println("Inicio: "+esteHilo.getName());
        for (int i=1; i<20; i++)
        {
        	System.out.print(i);
        	System.out.print(',');
        }
        System.out.println("Fin: "+esteHilo.getName());
    }

    public static void main(String args[]) {
    	Thread esteHilo=Thread.currentThread();
    	esteHilo.setName("Hilo Principal");
        System.out.println("Inicio: "+esteHilo.getName());
        for (int i=1; i<=5; i++)
        	(new Hilos01()).start();
        System.out.println("Fin: "+esteHilo.getName());
    }

}
