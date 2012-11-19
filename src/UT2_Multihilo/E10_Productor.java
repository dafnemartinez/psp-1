package UT2_Multihilo;

public class E10_Productor implements Runnable {
	
	private E10_Mensaje mensaje;

	public E10_Productor(E10_Mensaje c) {
		mensaje=c;
	}
	
	public void run() {
		int numeroMsj;
		while (true) {
			numeroMsj=(int)(Math.random()*100);
			mensaje.put(numeroMsj,"Prueba número "+Integer.toString(numeroMsj));
			System.out.println("Productor almacena el mensaje #"+numeroMsj);
			
			try {
				Thread.sleep((int)(Math.random()*1000));
			} catch (InterruptedException e) {};
		}
	}

}
