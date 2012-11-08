package UT1_multiproceso;

import java.util.*;
import java.io.*;

public class E02_ProcessBuilder2 {

	public static void main(String [] args)
	{
		/*ProcessBuilder permite ejecutar con mayor control. Por ejemplo:
			- fijar el directorio actual
			- cambiar el entorno
			
		ProcessBuilder(List<String> args): programa y sus argumentos
		ProcessBuilder(String args): lo mismo, en una cadena
		List<String> command(): devuelve lista que contiene programa y sus argumentos
		File directory(): devuelve directorio actual del invocante
		ProcessBuilder directory(dir): fija el directorio actual
		Map<String,String> environment(): devuelve variables de entorno definidas
		ProcessBuilder.Redirect redirectError(): devuelve el stderr
		ProcessBuilder redirectError(File f): cambia stderr
		ProcessBuilder.Redirect redirectInput(): devuelve el stdin
		ProcessBuilder redirectInput(File f): cambia stdin
		ProcessBuilder.Redirect redirectOutput(): devuelve el stdout
		ProcessBuilder redirectOutput(File f): cambia stdout
		process start(): arranca el proceso del objeto invocante.
		*/
		Process p=null;
		ProcessBuilder builder = new ProcessBuilder("ls", "-l", "/proc/");
		builder.redirectErrorStream();
		try
		{
			p = builder.start();
		} catch (IOException e)
		{
		}
		Scanner s = new Scanner(p.getInputStream()).useDelimiter("\\Z");  //Lee fichero completo \\Z
		System.out.println(s.next());
	}		 
}
