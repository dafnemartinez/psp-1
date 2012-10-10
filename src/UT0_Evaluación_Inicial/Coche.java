package UT0_Evaluación_Inicial;


public class Coche {
	private Motor motor;
	private Rueda [] r=new Rueda[4];

	Coche() {
		motor = new Motor();
		for (int i = 0; i < r.length; i++) {
			r[i] = new Rueda();
		}
	}

	public void rodar(int km) throws Exception {
		motor.rodar(km);
		for (int i = 0; i < r.length; i++) {
			r[i].rodar(km);
		}
	}
	
	public void print() {
		motor.println();
		for (int i=0; i<r.length; i++)
			r[i].println();
	}
	
	public void println() {
		this.print();
		System.out.print('\n');
	}
	
	public static void main(String[] args) {
		Coche c=new Coche();
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
