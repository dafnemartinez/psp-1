package UT2_Multihilo;

import java.io.*;

public class E15_Consumidor extends Thread {
	
	private PipedReader receptor=null;
	private BufferedReader flujoE=null;
	
	public E15_Consumidor(PipedReader re) {
		receptor=re;
		flujoE=new BufferedReader(receptor);
	}
	
	public void run() {
		while (true)
			obtenerMensaje();
	}
	
	public synchronized void obtenerMensaje() {
		String msj=null;
		try {
			msj=flujoE.readLine();
			System.out.println("Consumidor "+getName()+
					" obtuvo "+msj);
		} catch (IOException e) {}
	}
	
	protected void finalize() throws IOException {
		if (flujoE!=null) { flujoE.close(); flujoE=null; }
		if (receptor!=null) { receptor.close(); receptor=null; }
	}
}
