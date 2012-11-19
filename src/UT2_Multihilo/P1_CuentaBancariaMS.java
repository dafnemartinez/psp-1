package UT2_Multihilo;

import UT0_Repaso.CCC;
import UT0_Repaso.Fecha;

public class P1_CuentaBancariaMS {
	private CCC cuenta;
	private Fecha fechaApertura;
	private Double saldo;

	P1_CuentaBancariaMS(CCC cuenta, Fecha fechaApertura, double saldo) {
		this.cuenta=cuenta;
		this.fechaApertura=fechaApertura;
		this.saldo=saldo;
	}

	public void print() {
		System.out.println("Cuenta="+cuenta+" Fecha Apertura="+fechaApertura+" Saldo="+saldo);
	}

	public synchronized void ingresar(double dinero) {
			this.saldo+=dinero;
	}

	public synchronized void reintegrar(double dinero) throws Exception {
			if (dinero<this.saldo) {
				this.saldo-=dinero;
			} else
				throw new Exception("Saldo insuficiente: sacando "+dinero+" y solo hay "+this.saldo);
	}

	public double getSaldo() {
		return saldo;
	}

}
