package UT2_Multihilo;


//Ejemplo extendido: múltiples productores y consumidores, prioridades, grupos de hilos,
//	interrupciones...

public class E10_PruebaGrupoHilos {

	public static void main(String[] args) {
		ThreadGroup hilos=new ThreadGroup("Todos los hilos"); //grupo del hilo principal
		ThreadGroup productores=new ThreadGroup(hilos,"Hilos productores");
		ThreadGroup consumidores=new ThreadGroup(hilos,"Hilos consumidores");
		int np=5;
		int nc=10;
		int ha;
		
		E10_Mensaje m=new E10_Mensaje();

		//Array de Productores y sus hilos
		E10_Productor p[]=new E10_Productor[np];
		Thread hp[]=new Thread[np];
		
		//Array de Consumidores
		E10_Consumidor c[]=new E10_Consumidor[nc];
		Thread hc[]=new Thread[nc];

		//Crear productores y consumidores y arrancar su hilo
		for (int i=0; i<np; i++) {
			p[i]=new E10_Productor(m);
			hp[i]=new Thread(productores,p[i],"Productor "+i,Thread.MIN_PRIORITY);
			hp[i].start();
		}
		for (int i=0; i<nc; i++) {
			c[i]=new E10_Consumidor(m);
			hc[i]=new Thread(consumidores,c[i],"Consumidor "+i,Thread.MAX_PRIORITY);
			hc[i].start();
		}

		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {};

		//Finalizar

		//No hay join() para grupos, una lástima
		ha=hilos.activeCount();
		Thread[] t = new Thread[ha];
		hilos.enumerate(t);
		System.out.println ("Hilos aún activos en grupo " + hilos);
		for (int i=0; i<t.length; ++i) {
			System.out.println (t[i]);
		}

		//Señalizar a productores y consumidores para que terminen
		for (int i=0; i<np; i++) {
			p[i].salida();
			hp[i].interrupt();	//por si está en wait()
		}
			
		for (int i=0; i<nc; i++) {
			c[i].salida();
			hc[i].interrupt();	//por si está en wait()
		}

		System.out.println("Se acabó el hilo principal");
	}
}
