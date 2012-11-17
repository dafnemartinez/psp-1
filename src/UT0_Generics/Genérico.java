package UT0_Generics;

public class Genérico<T> {
	T ob;
	Genérico(T o) {
		ob=o;
	}
	T get() {
		return ob;
	}
	void showType() {
		System.out.println("Tipo de T: "+ob.getClass().getName());
	}

	public static void main(String args[]) {
		//con Integer:
		Genérico<Integer> iOb=new Genérico<Integer>(123);
		iOb.showType();
		int v=iOb.get();
		System.out.println("Valor: "+v);

		//con String:
		Genérico<String> sOb=new Genérico<String>("Hola, que tal");
		sOb.showType();
		String s=sOb.get();
		System.out.println("Valor: "+s);
	}
}
