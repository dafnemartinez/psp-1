package UT2_Multihilo;

import java.util.ArrayList;

public class P04_Buffer<T> {
	private ArrayList<T> v=null;
	private Integer g=0,s=0,num;

	public P04_Buffer(int num) throws Exception {
		v=new ArrayList<T>(num);
		this.num=num;
	}

	private int siguiente(int n) {
		return (n+1)%num;
	}

	//IMPORTANTE: g y s son objetos inmutables. Al reasignarlos a un nuevo valor se produce
	//autoboxing-autounboxing y un nuevo objeto, por lo que NO podemos usarlos para sincronizar.
	//
	public synchronized void clear() {
		g=s=0;
	}

	public synchronized void set(T valor) {
		while (siguiente(s)==g) {	  //en este caso el Buffer está lleno, esperar pare meter
			try {
				wait();
			} catch (InterruptedException e) {};
		}
		v.add(s,valor);
		s=siguiente(s);
		notifyAll();	//guardar dato y notificar a los consumidores de que hay datos
	}

	public synchronized T get() {
		T r;
		while (g==s) 			//buffer vacio, esperar para sacar
			try {
				wait();
			} catch (InterruptedException e) {}
		r=v.get(g);
		g=siguiente(g);
		notifyAll();		//notificar a los productores de que hemos dejado un hueco
		return r;
	}


	public boolean empty() {
		return g==s;
	}

	public boolean complete() {
		return siguiente(s)==g;
	}
}
