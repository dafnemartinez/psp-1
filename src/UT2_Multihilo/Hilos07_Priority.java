package UT2_Multihilo;

public class Hilos07_Priority implements Runnable {
//Forma recomendada de crear un hilo
//Ventaja: la clase podría extender a cualquier clase 

	private int prioridad=Thread.MIN_PRIORITY;
	
	public void run() {
		//importante, el hilo no se crea en el constructor, sino en run()
    	Thread.currentThread().setPriority(prioridad);
    	Thread.currentThread().setName("T"+prioridad);
        String nombre=Thread.currentThread().getName();
        for (int i=1; i<10; i++)
        {
        	System.out.print(i+"("+nombre+")");
        	System.out.println();
        }
    }

    Hilos07_Priority(int prio) {
    	prioridad=prio;
    }

    public static void main(String args[]) {
    	//min priority=1, max prio=10, norm prio=5
    	Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
    	for (int i=5; i>1; i--)
    		new Thread(new Hilos07_Priority(2*i)).start();
    		
    	Thread.currentThread().setPriority(Thread.NORM_PRIORITY);
    }
}
