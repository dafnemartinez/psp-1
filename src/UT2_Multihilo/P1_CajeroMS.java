package UT2_Multihilo;

import UT0_Repaso.CCC;
import UT0_Repaso.Fecha;

public class P1_CajeroMS implements Runnable {
	private double dinero;
	private P1_CuentaBancariaMS cuenta;

	public void run() {
		if (dinero>=0)
			cuenta.ingresar(dinero);
		else
			try {
				cuenta.reintegrar(-dinero);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
	}

	P1_CajeroMS(P1_CuentaBancariaMS cuenta,double dinero) {
		this.dinero=dinero;
		this.cuenta=cuenta;
	}


	public static void main(String args []) {
		P1_CuentaBancariaMS c=null;
		
		int numOperaciones=400;
		double saldoInicial=1000;
		
		Thread ti[]=new Thread[numOperaciones],
			   tr[]=new Thread[numOperaciones];
		
		try {
			c= new P1_CuentaBancariaMS(
					new CCC("2038.4712.  .3111483575"),
					new Fecha(),
					saldoInicial );
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		//Crear los hilos que meten y sacan dinero
		for (int i=0; i<numOperaciones; i++)
		{
			ti[i]=new Thread(new P1_CajeroMS(c,1.));	//cada P1_CajeroSC mete 1 euro
			tr[i]=new Thread(new P1_CajeroMS(c,-1.));	//cada P1_CajeroSC saca 1 euro
			ti[i].start();
			tr[i].start();
		}
		
		//Esperar que terminen los hilos
		for (int i=0; i<numOperaciones; i++)
		{
			try {
				ti[i].join();
				tr[i].join();
			} catch (InterruptedException e) {}
		}
		
		System.out.println("El saldo debería ser "+saldoInicial);
		System.out.println("saldo="+c.getSaldo());
	}
}
