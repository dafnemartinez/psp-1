package UT2_Multihilo;

import java.io.*;

public class E15_Productor extends Thread {

	private PipedWriter emisor=null;
	private PrintWriter flujoS=null;

	public E15_Productor(PipedWriter em) {
		emisor=em;
		flujoS=new PrintWriter(emisor);
	}

	public void run() {
		while (true) {
			almacenarMensaje();
			try {
				int msegs=(int)(Math.random()*100);
				sleep(msegs);
			} catch (InterruptedException e) {};
		}
	}

	public synchronized void almacenarMensaje() {
		int numeroMsj;
		String textoMensaje;
		numeroMsj=(int)(Math.random()*100);
		textoMensaje="Mensaje #"+numeroMsj;
		flujoS.println(textoMensaje);
		System.out.println("Productor "+getName()+" almacena "+textoMensaje);
	}

	protected void finalize() throws IOException {
		if (flujoS!=null) { flujoS.close(); flujoS=null; }
		if (emisor!=null) { emisor.close(); emisor=null; }
	}
}
