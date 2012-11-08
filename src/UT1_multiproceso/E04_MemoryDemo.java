package UT1_multiproceso;

public class E04_MemoryDemo {
	public static void main(String args[]) {
		Runtime r=Runtime.getRuntime();
		long mem1, mem2;
		Integer enteros[]=new Integer[1000];
		
		System.out.println("Memoria Total= "+r.totalMemory());
		mem1=r.freeMemory();
		System.out.println("Memoria Libre Inicial= "+mem1);
		r.gc();
		mem1=r.freeMemory();
		System.out.println("Memoria Libre tras GC= "+mem1);
		
		for (int i=0; i<1000; i++)
			enteros[i]=new Integer(i);

		mem2=r.freeMemory();
		System.out.println("Memoria Libre tras rellenar vector= "+mem2);
		System.out.println("Memoria usada en rellenar vector= "+(mem1-mem2));
		
		//descartar los enteros
		for (int i=0; i<1000; i++)
			enteros[i]=null;
		
		r.gc();
		
		mem2=r.freeMemory();
		System.out.println("Memoria tras descartar enteros y hacer GC= "+mem2);
		
	}
}
