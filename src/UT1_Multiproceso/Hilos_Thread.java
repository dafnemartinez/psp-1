package UT1_Multiproceso;

public class Hilos_Thread extends Thread {
//Forma NO recomendada de crear un hilo
//Problema: la clase no puede derivarse de otra, solamente de Thread
    public void run() {
        System.out.println("Nuevo hilo");
        for (int i=1; i<20; i++)
        {
        	System.out.print(i);
        	System.out.print(',');
        }
    }

    public static void main(String args[]) {
        for (int i=1; i<=5; i++)
        	(new Hilos_Thread()).start();
    }

}
