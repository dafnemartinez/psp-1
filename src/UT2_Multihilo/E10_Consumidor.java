package UT2_Multihilo;

public class E10_Consumidor implements Runnable {
	
	private E10_Mensaje mensaje;
	private boolean salir=false;

	public E10_Consumidor(E10_Mensaje c) {
		mensaje=c;
	}
	
	public void salida() {	//interrupt() es obsoleto, usar flag
		salir=true;
	}

	public void run() {
		String msj;
		while (!salir) {
			msj=mensaje.get();
			System.out.println(Thread.currentThread().getName()+" obtuvo mensaje: "+msj);
		}
	}
}
