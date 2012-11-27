package UT2_Multihilo;

import java.io.*;

public class E15_PipesEjemplo {
	public static void main(String args[]) {
		try {
			PipedWriter emisor=new PipedWriter();
			PipedReader receptor=new PipedReader(emisor);
			
			E15_Productor p1=new E15_Productor(emisor);
			E15_Consumidor c1=new E15_Consumidor(receptor);
			p1.start();
			c1.start();
		} catch (IOException e) {};
	}
}
