package UT0_Ficheros;

import java.io.*;

public class FiltroFicheros implements FilenameFilter {
	private String ext;
	
	FiltroFicheros(String ext) {
		this.ext="."+ext;
	}
	
	public boolean accept(File dir, String name) {
		return name.endsWith(ext);
	}
	
	public static void main (String [] args) {
		for (int i=0; i<args.length; i++) {
			FilenameFilter filtro=new FiltroFicheros(args[i]);
			File f=new File("/var/www/");
			String s[]=f.list(filtro);
			for (int j=0; j<s.length; j++)
				System.out.println(s[j]);
		}
	}
}
