package UT0_generics;

public class Gen<T> {
		T ob;
		Gen(T o) {
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
		Gen<Integer> iOb=new Gen<Integer>(123);
		iOb.showType();
		int v=iOb.get();
		System.out.println("Valor: "+v);
		
		//con String:
		Gen<String> sOb=new Gen<String>("Hola, que tal");
		sOb.showType();
		String s=sOb.get();
		System.out.println("Valor: "+s);
	}
}
