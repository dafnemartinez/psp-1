package UT0_Evaluación_Inicial;

public class Motor {
	private int cubicajeCC;
	private int potenciaCV;
	private static final int limiteKm = 300000;
	private int rodaduraKm = 0;

	Motor(int cubicajeCC, int potenciaCV) {
		this.cubicajeCC=cubicajeCC;
		this.potenciaCV=potenciaCV;
	}

	// Motor Estándar
	Motor() {
		cubicajeCC=1900;
		potenciaCV=105;
	}

	public void rodar(int km) throws Exception {
		rodaduraKm+=km;
		if (rodaduraKm>limiteKm)
			throw new Exception("Motor agotado!");
	}

	public void print() {
		int difKm=limiteKm-rodaduraKm;
		System.out.println("Cubicaje: "+cubicajeCC+" cc");
		System.out.println("Potencia: "+potenciaCV+" CV");
		if ( difKm > 0)
			System.out.println("Km: "+rodaduraKm+" restan "+difKm);
		else
			System.out.println("Km: "+rodaduraKm+" excedidos "+ (-difKm));
	}
	
	public void println() {
		this.print();
		System.out.print('\n');
	}
	
	public static void main(String[] args) {
		Motor m=new Motor();
		try {
			m.rodar(1000);
			m.rodar(250000);
			m.rodar(50000);
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		m.println();
	}
}
