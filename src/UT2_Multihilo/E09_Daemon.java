package UT2_Multihilo;

public class E09_Daemon implements Runnable {
	
	private Thread t;
	
	E09_Daemon() {
		//setDaemon(true);  //al descomentar esto se convierte en daemon. Salida silenciosa
		t=new Thread(this);
		t.start();
	}
	
	public void run()
	{
		char bel='\u0007';	//beep de terminal, no esperes que pite en Linux
		while (true) {
			try {
				Thread.sleep(1000);
			}
			catch (InterruptedException e) {}
			System.out.print(bel+".");
		}
	}
	
	public static void main(String args[]) {
		new E09_Daemon();
	}
}
