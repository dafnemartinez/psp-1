package UT0_Repaso;

import java.util.regex.*;

public class NIF_NIE {

	private static final String excepcionMsg="NIF Incorrecto";
	private static final String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
	private static final Pattern nifPattern =
	   Pattern.compile("([XYZ])?-?(\\d{1,8})-?(["+letras+letras.toLowerCase()+"]?)");
	
	private char letra_ini;
	private int n;
	private char letra_fin;

	public NIF_NIE(String nif) throws Exception
	{
	   //si es NIE
	   Matcher m = nifPattern.matcher(nif);
	
	   if(m.matches()){   //se cumple el patrón regex

		   if (m.group(1).length()==0)	// viene sin letra
			   letra_ini=' ';
		   else
			   letra_ini=m.group(1).charAt(0);
		   
		   n=Integer.parseInt(m.group(2));
		   
		   //comprobar el cálculo de la letra
	       int resto = n % 23;

		   if (m.group(3).length()==0)	// viene sin letra
			   letra_fin=letras.charAt(resto);
		   else	//sí que hay letra
			   letra_fin=m.group(3).charAt(0);
		   
	       if (letras.charAt(resto)!=letra_fin)  //comprobar letra 
	    	   throw new Exception(excepcionMsg);
	   }
	   else
		   throw new Exception(excepcionMsg);
	}
	
	public void print() {
		System.out.printf("%c%s%c",letra_ini,n,letra_fin);
	}
	
	public void println() {
		print();
		System.out.println();
	}
	
	/*
	public static void main(String [] args) {
		NIF_NIE n=null;
		try {
			n=new NIF_NIE("22214412");
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		n.println();
	}
	*/
}