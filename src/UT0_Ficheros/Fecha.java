package UT0_Ficheros;

import java.util.GregorianCalendar;
import java.util.regex.*;

public class Fecha {
	private int dia, mes, año;
	private static final String exceptionMsg = "Fecha incorrecta";
	private static final Pattern fechaPattern = Pattern
			.compile("((\\d{1,2})[-./]?(\\d{1,2})[-./]?(\\d{1,4})");

	public Fecha(int dia, int mes, int año) throws Exception {
		this(dia + "-" + mes + "-" + año);
	}

	public Fecha() throws Exception {
		this(new GregorianCalendar().get(GregorianCalendar.DAY_OF_MONTH),
				new GregorianCalendar().get(GregorianCalendar.MONTH) + 1,
				new GregorianCalendar().get(GregorianCalendar.YEAR));
	}

	Fecha(String fecha) throws Exception
	{
		
		Matcher f = fechaPattern.matcher(fecha);
		if(f.matches()){ //se cumple
			int dia,mes,año;
			dia=Integer.parseInt(f.group(1));
			mes=Integer.parseInt(f.group(2));
			año=Integer.parseInt(f.group(3));
			
			if (dia < 1 || dia > 31 )
				throw new Exception(exceptionMsg);
			else if (mes < 1 || mes > 12)
				throw new Exception(exceptionMsg);
			else if (mes == 2 && dia > 28)
				throw new Exception(exceptionMsg);
			else if (año == 0)
				throw new Exception(exceptionMsg);
			else
			this.dia = dia;
			this.mes = mes;
			this.año = año;

		}
		else{
			throw new Exception(exceptionMsg);
		}
	}

	public void print(){
		System.out.println(dia + "-" + mes + "-" + año);
	}

	public void println() {
		print();
		System.out.println();
	}

	public int getDia() {
		return dia;
	}

	public int getMes() {
		return mes;
	}

	public int getAnno() {
		return año;
	}

	public static void main(String[] args) {
	}


}