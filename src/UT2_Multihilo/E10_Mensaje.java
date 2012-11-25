package UT2_Multihilo;

public class E10_Mensaje {

	private String textoMensaje;
	private int numeroMensaje;
	private boolean disponible=false;

	public synchronized void put(int num, String texto) {
		boolean interrumpido=false;
		try {
			while (disponible) {
				interrumpido=false;
				wait();	//dormir hasta que otro hilo recoja el mensaje
			}
		} catch (InterruptedException e) {};
		if (!interrumpido) {
			numeroMensaje=num;
			textoMensaje=texto;
			disponible=true;
			notifyAll();	//despertar a los hilos en espera
		}
	}

	public synchronized String get() {
		boolean interrumpido=false;
		while (!disponible) {
			try {
				interrumpido=false;
				wait();	//dormir hasta que haya algo
			} catch (InterruptedException e) {
				disponible=true; //esto hará que se pueda salir del bucle al interrumpir
				interrumpido=true;
			};
		}
		if (interrumpido) {
			return("Interrumpido!!!");
		} else {
			disponible=false;
			notifyAll();
			return "#"+numeroMensaje+": "+textoMensaje;
		}
	}
}
