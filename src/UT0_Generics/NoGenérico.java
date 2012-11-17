package UT0_Generics;

public class NoGenérico {
	Object ob;
	NoGenérico(Object o) {
		ob=o;
	}
	Object get() {
		return ob;
	}
	void showType() {
		System.out.println("Tipo de T: "+ob.getClass().getName());
	}

	public static void main(String args[]) {
		//con Integer:
		NoGenérico iOb=new NoGenérico(123);
		iOb.showType();
		int v=(Integer)iOb.get();
		System.out.println("Valor: "+v);

		//con String:
		NoGenérico sOb=new NoGenérico("Hola, que tal");
		sOb.showType();
		String s=(String)sOb.get();
		System.out.println("Valor: "+s);

		//Curiosidades
		iOb=sOb;	//Esto compila, aunque no tiene sentido
		v=(Integer)iOb.get();

		/* Produce error runtime:
		java.lang.ClassCastException: java.lang.String cannot be cast to java.lang.Integer
		 */
	}
}
