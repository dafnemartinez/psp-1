package UT2_Multihilo;

public class P04_BufferPrueba {
	
	public static void main(String args[]) throws Exception {
		
		//Crear el buffer
		P04_Buffer<Integer> b=new P04_Buffer<Integer>(25);
		
		//Crear productores y consumidores
		int np=4, nc=1;
		
		//Crear arrays de productores y consumidores, hilos productores y hilos consumidores
		P04_Productor p[]=new P04_Productor[np];
		P04_Consumidor c[]=new P04_Consumidor[nc];
		Thread pt[]=new Thread[np];
		Thread ct[]=new Thread[nc];

		//Crear productores y consumidores propiamente dichos 
		for (int i=0; i<np; i++)
			p[i]=new P04_Productor(b);
		for (int i=0; i<nc; i++)
			c[i]=new P04_Consumidor(b);

		//Crear y arrancar hilos
		for (int i=0; i<np; i++) {
			pt[i]=new Thread(p[i],"Productor "+i);
			pt[i].setPriority(Thread.MAX_PRIORITY);
			pt[i].start();
		}
		for (int i=0; i<nc; i++) {
			ct[i]=new Thread(c[i],"Consumidor "+i);
			pt[i].setPriority(Thread.NORM_PRIORITY);
			ct[i].start();
		}
		Thread.sleep(1000);
	}
}
