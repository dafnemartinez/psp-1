package UT2_Multihilo;

public class E10_Mensaje {

	private String textoMensaje;
	private int numeroMensaje;
	private boolean disponible=false;
	
	public synchronized void put(int num, String texto) {
		while (disponible) {
			try {
				wait();	//dormir hasta que otro hilo recoja el mensaje
			} catch (InterruptedException e) {};
		}
		numeroMensaje=num;
		textoMensaje=texto;
		disponible=true;
		notifyAll();	//despertar a los hilos en espera
	}
	
	public synchronized String get() {
		while (!disponible) {
			try {
				wait();	//dormir hasta que haya algo
			} catch (InterruptedException e) {};
		}
		disponible=false;
		notifyAll();
		return "#"+numeroMensaje+": "+textoMensaje; 
	}
}
