package UT2_Multihilo;

public class E10_Consumidor implements Runnable {
	
	private E10_Mensaje mensaje;

	public E10_Consumidor(E10_Mensaje c) {
		mensaje=c;
	}
	
	public void run() {
		String msj;
		while (true) {
			msj=mensaje.get();
			System.out.println("Consumidor obtuvo mensaje: "+msj);
		}
	}
}
