package UT0_Repaso;

import java.io.File;

public class PruebaFicheros {
	private static void p(String s) {
		System.out.println(s);
	}
	
	private static void datosArchivo(File f) {
		p("Nombre: "+f.getName());
		p("Ruta: "+f.getPath());
		p("Ruta Absoluta: "+f.getAbsolutePath());
		p("Conseguir su padre: "+f.getParent());
		p("¿existe?: "+(f.exists()?"si":"no"));
		p("¿se puede leer?: "+(f.canRead()?"si":"no"));
		p("¿se puede escribir?: "+(f.canWrite()?"si":"no"));
		p("¿es directorio?: "+(f.isDirectory()?"si":"no"));
		p("¿es fichero?: "+(f.isFile()?"si":"no"));
		p("¿es absoluto?: "+(f.isAbsolute()?"si":"no"));
		p("última modificación: "+f.lastModified());
		p("");
	}
	
	public static void main(String[] args) {
		for (int i=0; i<args.length; i++) 
			datosArchivo(new File(args[i]));
	}
}
