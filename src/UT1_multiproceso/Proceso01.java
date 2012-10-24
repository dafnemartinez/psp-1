package UT1_multiproceso;

import java.util.*;
import java.io.*;

public class Proceso01 {

	public static void main(String [] args)
	{
		Process p=null;
		ProcessBuilder builder = new ProcessBuilder("ls", "-ld", "/");
		builder.redirectErrorStream();
		try
		{
			p = builder.start();
		} catch (IOException e)
		{
		}
		Scanner s = new Scanner(p.getInputStream()).useDelimiter("\\Z");
		System.out.println(s.next());
	}		 
}
