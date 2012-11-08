package UT1_multiproceso;

	import java.io.*;

	//captura la salida (stdio) de un proceso externo
	
	public class E01_Process {
	  public static void main(String args[]) {
	    try {
	      String linea;
	      
	      //Runtime no se puede instanciar, es para obtener una referencia al runtime del proceso actual
	      Runtime r = Runtime.getRuntime();
	      Process p = r.exec("ls -l /");
	      
	      
	      /*Métodos de Runtime y Process:
	      	void addShutdownHook(Thread t): ejecuta el Thread antes de finalizar la JVM
	      	void removeShutdownHook(Thread t): ejecuta el Thread antes de finalizar la JVM
	      	Process exec(String p): ejecuta un programa (permite opciones)
	      	Process exec(String p, String e[]: ejecuta con entorno
	      	Process exec(String c[]): ejecuta un comando formado por el contenido de c
	      	Process exec(String c[], String e[]): con entorno
	      	void exit (int code)
	      	long freeMemory()
	      	long totalMemory()
	      	void gc(): garbage collection
	      	void halt(int code): termicion inmediata, sin hilos finalizadores
	      	p.waitFor(): esperar a que termine el proceso hijo "p"
	      */
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
