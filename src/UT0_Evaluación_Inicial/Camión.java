package UT0_Evaluación_Inicial;

public class Camión extends Coche {
	private double tara;
	private double pma;
	private Rueda [] rr;

	Camión(Double tara, Double pma, int numRuedasRemolque) {
		super();
		this.tara=tara;
		this.pma=pma;
		this.rr=new Rueda[numRuedasRemolque];
		for (int i = 0; i < numRuedasRemolque; i++)
			rr[i]=new Rueda();
	}

	Camión() {
		tara=8500;
		pma=24000;
		rr = new Rueda[6];
		for (int i = 0; i < rr.length; i++)
			rr[i]=new Rueda();
	}

	public void rodar(int km) throws Exception {
		super.rodar(km);
		for (int i = 0; i < rr.length; i++)
				rr[i].rodar(km);
	}
	
	public void print() {
		super.print();
		System.out.println("");
		System.out.println("Tara: "+tara+" kg");
		System.out.println("PMA: "+pma+" kg");
		for (int i=0; i<rr.length; i++)
			rr[i].println();
	}
	
	public void println() {
		this.print();
		System.out.print('\n');
	}
	
	public static void main(String[] args) {
		Camión c=new Camión();
		try {
			c.rodar(1000);
			c.rodar(2000);
			c.rodar(512);
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		c.println();
	}
}
