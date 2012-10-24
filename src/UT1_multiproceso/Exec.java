package UT1_multiproceso;

	import java.io.*;

	//captura la salida (stdio) de un proceso externo
	
	public class Exec {
	  public static void main(String args[]) {
	    try {
	      String linea;
	      
	      Process p = Runtime.getRuntime().exec("ls -l /");
	      
	      BufferedReader bri = new BufferedReader
	        (new InputStreamReader(p.getInputStream()));
	      BufferedReader bre = new BufferedReader
	        (new InputStreamReader(p.getErrorStream()));
	      
	      //std input
	      while ((linea = bri.readLine()) != null) {
	        System.out.println(linea);
	      }
	      bri.close();
	      
	      //stderr
	      while ((linea = bre.readLine()) != null) {
	        System.out.println(linea);
	      }
	      bre.close();
	      
	      p.waitFor();	//esperar 
	      System.out.println("Fin.");
	    }
	    catch (Exception err) {
	      err.printStackTrace();
	    }
	  }
	}
