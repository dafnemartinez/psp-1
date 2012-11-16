package UT2_Multihilo;

public class E02_Runnable implements Runnable {
//Forma recomendada de crear un hilo
//Ventaja: la clase podría extender a cualquier clase 
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
        (new Thread(new E02_Runnable())).start();
    }
}
