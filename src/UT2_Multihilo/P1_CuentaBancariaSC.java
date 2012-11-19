package UT2_Multihilo;

import UT0_Repaso.CCC;
import UT0_Repaso.Fecha;

public class P1_CuentaBancariaSC {
	private CCC cuenta;
	private Fecha fechaApertura;
	private Double saldo;

	P1_CuentaBancariaSC(CCC cuenta, Fecha fechaApertura, double saldo) {
		this.cuenta=cuenta;
		this.fechaApertura=fechaApertura;
		this.saldo=saldo;
	}

	public void print() {
		System.out.println("Cuenta="+cuenta+" Fecha Apertura="+fechaApertura+" Saldo="+saldo);
	}

	public void ingresar(double dinero) {
		synchronized(saldo)
		{ 
			this.saldo+=dinero;	 //Race condition
		}
	}

	public void reintegrar(double dinero) throws Exception {
		synchronized(saldo)
		{
			if (dinero<=this.saldo) {   	 //Race condition
				this.saldo-=dinero;
			} else
				throw new Exception("Saldo insuficiente: sacando "+dinero+" y solo hay "+this.saldo);
		 } 
	}

	public double getSaldo() {
		return saldo;
	}

}
