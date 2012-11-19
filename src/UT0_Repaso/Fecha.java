package UT0_Repaso;

import java.util.GregorianCalendar;
import java.util.regex.*;

public class Fecha {

	private int dia, mes, año;

	private static final String msg="Fecha: ";
	public static final int dm []= {31,28,31,30,31,30,31,31,30,31,30,31};
	public static final String sep="/";			//separador por defecto
	public static final int JGREG= 15 + 31*(10+12*1582);	
	public static double HALFSECOND = 0.5;

	//Constructor sin argumentos, se construye con la fecha actual
	public Fecha() throws Exception {
		GregorianCalendar gregorianCalendar=new GregorianCalendar();            
		mes=gregorianCalendar.get(GregorianCalendar.MONTH)+1;            
		dia=gregorianCalendar.get(GregorianCalendar.DAY_OF_MONTH);
		año=gregorianCalendar.get(GregorianCalendar.YEAR);
	}

	//Constructor por copia
	public Fecha(Fecha f) {
		dia=f.getDia();
		mes=f.getMes();
		año=f.getAño();
	}
	public Fecha(String fecha) throws Exception {
		set(fecha);
	}

	public Fecha(int dia, int mes, int año) throws Exception {
		this(dia+sep+mes+sep+año);
	}

	//Construir fecha a partir de dia juliano (jd). Útil para operar con fechas
	public Fecha(double jd) {
		int jalpha,ja,jb,jc,jdTmp,je;
		double julian = jd + HALFSECOND / 86400.0;
		ja = (int) julian;
		if (ja>= JGREG) {
			jalpha = (int) (((ja - 1867216) - 0.25) / 36524.25);
			ja = ja + 1 + jalpha - jalpha / 4;
		}

		jb = ja + 1524;
		jc = (int) (6680.0 + ((jb - 2439870) - 122.1) / 365.25);
		jdTmp = 365 * jc + jc / 4;
		je = (int) ((jb - jdTmp) / 30.6001);
		dia = jb - jdTmp - (int) (30.6001 * je);
		mes = je - 1;
		if (mes > 12) mes = mes - 12;
		año = jc - 4715;
		if (mes > 2) año--;
		if (año <= 0) año--;
	}

	//Asignar valor de fecha directamente
	public void set(int dia, int mes, int año) throws Exception {
		set(dia+sep+mes+sep+año);
	}

	public void set(Fecha f) throws Exception {
		set(f.getDia(),f.getMes(),f.getAño());
	}
	
	public void set(String fecha) throws Exception {
		Pattern fechaRegex=Pattern.compile("^(\\d{1,2})[./-]?(\\d{1,2})[./-]?([+-]?\\d{1,4})$"); 
		Matcher m = fechaRegex.matcher(fecha);
		// boolean found=m.find();	//para depurar
		if(m.matches()) { //se cumple el patrón, es decir, esto se parece a una fecha
			int dia,mes,año, diasMes;

			//Separar elementos de la fecha
			dia=Integer.parseInt(m.group(1));
			mes=Integer.parseInt(m.group(2));
			año=Integer.parseInt(m.group(3));

			if (año==0)	//no existe el año 0
				throw new Exception(msg+fecha+" año 0 no existe");

			if (mes<1 || mes>12)
				throw new Exception(msg+fecha+" mes incorrecto");

			diasMes=dm[mes-1];

			if (mes==2 && ( año%4==0 && año%400!=0) )		//determinar si es bisiesto 
				diasMes=29;		

			if (dia<1 || dia>diasMes)
				throw new Exception(msg+fecha+" dia incorrecto");

			this.dia = dia;
			this.mes = mes;
			this.año = año;
		}
		else {
			throw new Exception(msg+fecha+" no es una fecha");
		}
	}

	//Calcular dia juliano de una fecha
	public double jd() {
		int añoJuliano = año;
		if (año < 0) añoJuliano++;
		int mesJuliano = mes;
		if (mes > 2) {
			mesJuliano++;
		}
		else {
			añoJuliano--;
			mesJuliano += 13;
		}

		double julian = (java.lang.Math.floor(365.25 * añoJuliano)
				+ java.lang.Math.floor(30.6001*mesJuliano) + dia + 1720995.0);
		if (dia + 31 * (mes + 12 * año) >= JGREG) {
			// change over to Gregorian calendar
			int ja = (int)(0.01 * añoJuliano);
			julian += 2 - ja + (0.25 * ja);
		}
		return java.lang.Math.floor(julian);
	}

	//sumar (o restar) dias a una fecha
	public void add(int dias)
	{
		double jd=this.jd()+dias;
		try {
		set(new Fecha(jd));
		} catch (Exception e) {System.out.println(msg+" error al convertir jd="+jd); };
	}
	
	//restar dos fechas
	public double substract(Fecha f) {
		return this.jd()-f.jd();
	}

	public void print(){
		System.out.print(dia+sep+mes+sep+año);
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

	public int getAño() {
		return año;
	}

	/*
	public static void main(String[] args) {
		try {
			Fecha f=new Fecha(new Fecha("28/2/2000").jd());
			f.println();  //debe salir la misma
			new Fecha(31,12,2012).println();
			new Fecha("23112001").println();
			new Fecha("29-2--1984").println();
			f=new Fecha("19.9.2001");
			f.println();
			f.set("1-1--4712");
			f.println();
			Fecha f1=new Fecha();
			Fecha f2=new Fecha(f1);
			f2.add(300);	//f2=f1+300 dias
			System.out.println(f2.substract(f1));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		};
	}
	*/
} 