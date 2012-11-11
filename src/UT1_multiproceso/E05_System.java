package UT1_multiproceso;

public class E05_System {
	/*Usos comunes de System:
	arraycopy(src, src_start, target, target_start, size)
	clearProperty()
	console()
	currentTimeMillis()
	exit()
	gc()
	getenv()
	getProperties()
	setProperties()
	getProperty()
	nanoTime()
	*/
	public static void main(String args[]) {
		long start, end;
		System.out.println("Midiendo lo que tarda un bucle desde 0 hasta 100e6");
		
		start=System.currentTimeMillis();
		for (long i=0; i<100000000L; i++);
		end=System.currentTimeMillis();

		System.out.println("Tiempo: "+(end-start)+" milisegundos");
		
		final byte a[]={65, 66, 67, 68, 69, 70, 71, 72, 73, 74 };
		final byte b[]={77, 77, 77, 77, 77, 77, 77, 77, 77, 77 };
		
		System.out.println("a="+new String(a));
		System.out.println("b="+new String(b));
		System.arraycopy(a, 0, b, 0, a.length);
		System.out.println("a="+new String(a));
		System.out.println("b="+new String(b));
		System.arraycopy(a, 0, a, 1, a.length-1);
		System.arraycopy(b, 1, b, 0, b.length-1);
		System.out.println("a="+new String(a));
		System.out.println("b="+new String(b));

		System.out.println(System.getProperty("user.dir"));
	}
}
