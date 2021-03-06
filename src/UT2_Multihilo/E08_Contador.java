package UT2_Multihilo;

public class E08_Contador implements Runnable {
	private Thread cuentaAtras;
	
	E08_Contador(String nombre) {
		cuentaAtras=new Thread(this);  //target=this objeto cuyo run() se ejecutará
		if (nombre!=null) 
			cuentaAtras.setName(nombre);
		//cuentaAtras.setDaemon(true);	//probar que pasa llamando a este método
		System.out.println("Hilo "+nombre+".isdaemon()="+cuentaAtras.isDaemon());
		cuentaAtras.start();
	}
	
	E08_Contador() {
		this(null);
	}
		
	public void run() {
		for (int i=1000; i>0; i--)
			System.out.print("\t\t\t"+cuentaAtras.getName()+" "+i+"\r");
		System.out.println();
	}
	
	public static void main(String [] args) {
		new E08_Contador("Hilo 1->");
		new E08_Contador("Hilo 2->");
		try {
		  Thread.sleep(10);	//probar aquí con diferentes tiempos
		} catch (InterruptedException e) {
			
		}
		System.out.println("Programa Principal\n");
		//System.exit(0);		//probar que pasa si se hace esto
	}
}
