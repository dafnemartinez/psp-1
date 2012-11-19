package UT2_Multihilo;

public class E10_Prueba {

	public static void main(String[] args) {
		E10_Mensaje m=new E10_Mensaje();
		E10_Productor p=new E10_Productor(m);
		E10_Consumidor c=new E10_Consumidor(m);
		new Thread(p).start();
		new Thread(c).start();
	}

}
