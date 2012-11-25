package UT2_Multihilo;

public class E10_Productor implements Runnable {
	
	private E10_Mensaje mensaje;
	private boolean salir=false;		//interrupt() para hilos es obsoleto. Usar flag de salida
 
	public E10_Productor(E10_Mensaje c) {
		mensaje=c;
	}

	public void salida() {
		salir=true;
	}

	public void run() {
		int numeroMsj;
		while (!salir) {
			numeroMsj=(int)(Math.random()*100);
			mensaje.put(numeroMsj,"Prueba número "+Integer.toString(numeroMsj));
			System.out.println(Thread.currentThread().getName()+" almacena el mensaje #"+numeroMsj);
		
			try {
				Thread.sleep((int)(Math.random()*1000));
			} catch (InterruptedException e) {};
		}
	}

}
