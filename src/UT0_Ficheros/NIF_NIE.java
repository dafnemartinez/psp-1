package UT0_Ficheros;

import java.util.regex.*;

public class NIF_NIE {

	private static final String excepcionMsg="NIF Infcorrecto";
	private static final String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
	private static final Pattern nifPattern =
	   Pattern.compile("(\\d{1,8})-?(["+letras+letras.toLowerCase()+"])");
	
	private char letra_ini;
	private int n;
	private char letra_fin;

	NIF_NIE(String nif) throws Exception
	{
	   //si es NIE
	   if (nif.toUpperCase().startsWith("X")||
		   nif.toUpperCase().startsWith("Y")||
		   nif.toUpperCase().startsWith("Z") )
		   letra_ini = nif.charAt(0);
	   else
		   letra_ini=' ';
	 
	   Matcher m = nifPattern.matcher(nif);
	
	   if(m.matches()){
		   n=Integer.parseInt(m.group(1));
		   letra_fin= m.group(2).charAt(0);
		   
		   //comprobar el cálculo de la letra
	       int resto = n % 23;
	       
	       if (letras.charAt(resto)!=letra_fin)
	    	   throw new Exception(excepcionMsg);
	   }
	   else
		   throw new Exception("excepcionMsg");
	}
	
	public void print() {
		System.out.printf("%c%s%c",letra_ini,n,letra_fin);
	}
	
	public void println() {
		print();
		System.out.println();
	}
	
	public static void main(String [] args) {
		NIF_NIE n=null;
		try {
			n=new NIF_NIE("22214412T");
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		n.println();
	}
}