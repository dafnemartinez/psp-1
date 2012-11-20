package UT2_Multihilo;

import UT0_Repaso.CCC;
import UT0_Repaso.Fecha;

//Implementación de bloqueo con secciones críticas mediante bloques synchronized {}
//ventaja: granularidad fina en multihilo

public class P1_CuentaBancariaSC {
	private CCC cuenta;
	private Fecha fechaApertura;
	private Double saldo;
	Object saldoLck=new Object();	//saldoLck existe solamente para bloquear acceso a saldo

	P1_CuentaBancariaSC(CCC cuenta, Fecha fechaApertura, double saldo) {
		//Los constructores no se sincronizan
		this.cuenta=cuenta;
		this.fechaApertura=fechaApertura;
		this.saldo=saldo;
	}

	public void print() {
		System.out.println("Cuenta="+cuenta+" Fecha Apertura="+fechaApertura+" Saldo="+saldo);
	}

	public void ingresar(double dinero) {
		//ATENCIÓN: varias posibilidades
		// synchronized(this): se comporta como método sincronizado, todo irá bien
		// syncronized(Lock): Lock es un Object que NO modificamos, todo irá bien
		// synchronized(Object): PELIGRO, si modificamos el objeto puede que involuntariamente
				//estemos cambiando la referencia a un nuevo objeto, perdemos el monitor porque
				//el objeto deja de estar referenciado (SUTIL PROBLEMA)
		synchronized(saldo) { 
			saldo+=dinero;	 //Race condition
				//Por si fuera poco, este saldo YA NO ES el que era al sincronizar
				//(los peligros del autoboxing (tipo primitivo->Wrapper) y autounboxing (Wrapper->tipo primitivo)
		}
	}

	public void reintegrar(double dinero) throws Exception {
		synchronized(saldo) {
			if (dinero<=saldo) {   	 //Race condition
				saldo-=dinero;
			} else
				throw new Exception("Saldo insuficiente: sacando "+dinero+" y solo hay "+saldo);
		} 
	}

	public double getSaldo() {
		synchronized (saldo) {
			return saldo;
		}
	}
}
