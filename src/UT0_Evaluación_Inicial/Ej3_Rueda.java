package UT0_Evaluación_Inicial;

public class Ej3_Rueda {

	private int diametroPulgadas;
	private int anchuraNominalMm;
	private int ratioAspectoPc;
	private static final int limiteKm = 60000;
	private int rodaduraKm = 0;
	private boolean pinchada = false;
	private boolean cambiar = false;

	Ej3_Rueda(int diametroPulgadas, int anchuraNominalMm,
			int ratioAspectoPc) {
		this.diametroPulgadas = diametroPulgadas;
		this.anchuraNominalMm = anchuraNominalMm;
		this.ratioAspectoPc = ratioAspectoPc;
	}

	// Rueda Estándar
	Ej3_Rueda() {
		this.diametroPulgadas = 16;
		this.anchuraNominalMm = 205;
		this.ratioAspectoPc = 55;
	}

	public void rodar(int km) throws Exception {
		if (! pinchada) {
			this.rodaduraKm += km;
			if (rodaduraKm >= limiteKm) {
				cambiar = true;
			}
		} else
			throw new Exception("Esta pinchada, no puedes rodar!");
	}

	public void pinchar() {
		pinchada = true;
	}

	public void reparar() {
		pinchada = false;
	}
	
	public void print() {
		int difKm=limiteKm-rodaduraKm;
		System.out.println("Diámetro: "+diametroPulgadas+'"');
		System.out.println("Anchura: "+anchuraNominalMm+" mm");
		System.out.println("Relación de Aspecto: "+ratioAspectoPc+'%');
		if ( (difKm) > 0)
			System.out.println("Km: "+rodaduraKm+" restan "+difKm);
		else
			System.out.println("Km: "+rodaduraKm+" excedidos "+ (-difKm));
		System.out.println("Pinchada: "+pinchada);
		System.out.println("Cambiar: "+cambiar);
	}
	
	public void println() {
		print();
		System.out.print('\n');
	}
	
	public static void main(String[] args) {
		Ej3_Rueda r1=new Ej3_Rueda(), r2=new Ej3_Rueda(165,14,175);
		try {
			r1.rodar(75000);
			r1.pinchar();
			r2.rodar(34500);
			
			r1.println();
			r2.println();
			
			r1.rodar(5);
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}