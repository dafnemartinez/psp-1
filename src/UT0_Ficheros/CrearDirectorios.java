package UT0_Ficheros;

import java.io.*;

public class CrearDirectorios {
	private final static String uso=
			"Uso: CrearDirectorios ruta1 ...\n" +
			"Crea cada ruta\n\n" +
			"Uso: CrearDirectorios -d ruta1 ...\n" +
			"Borra cada ruta\n\n"+
			"Uso: CrearDirectorios -r ruta1 ruta2\n" +
			"Renombra ruta\n\n";
	
	private static void uso() {
		System.err.println(uso);
		System.exit(1);
	}
	
	private static void datosArchivo(File f) {
		System.out.println(
				"Ruta Absoluta: "+f.getAbsolutePath()+
				"\nPuede Leer: "+f.canRead()+
				"\nPuede Escribir:"+f.canWrite()+
				"\nConseguir el Nombre: "+f.getName()+
				"\nConseguir su padre: "+f.getParent()+
				"\nConseguir Ruta: "+f.getPath()+
				"\nLongitud: "+f.length()+
				"\nÚltima modificación: "+f.lastModified());
		if (f.isFile())
			System.out.println("Es un archivo");
		else if (f.isDirectory())
			System.out.println("Es un directorio");
	}
	
	public static void main(String[] args) {
		if (args.length<1)
			uso();
		if (args[0].equals("-r")) {			
			if (args.length!=3)
				uso();
			File viejo=new File(args[1]), nuevo=new File(args[2]);
			viejo.renameTo(nuevo);
			datosArchivo(viejo);
			datosArchivo(nuevo);
			return;
		}
	
		int contador=0;
		boolean borrar=false;
		if (args[0].equals("-d")) {
			contador++;
			borrar=true;
		}
		for ( ; contador<args.length; contador++) {
			File f=new File(args[contador]);
			if (f.exists()) {
				System.out.println(f+" existe");
				if (borrar) {
					System.out.println("borrando..."+f);
					f.delete();
				}
			}
			else {
				if (!borrar) {
					f.mkdirs();
					System.out.println("creado "+f);
				}
			}
			datosArchivo(f);
		}
	}
}
