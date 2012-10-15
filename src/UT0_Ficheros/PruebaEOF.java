package UT0_Ficheros;

import java.io.*;

public class PruebaEOF {
	private static final String fichero="/etc/network/interfaces";
	public static void main(String[] args)
	throws IOException {
		DataInputStream entrada=
			new DataInputStream(
				new BufferedInputStream(
					new FileInputStream(fichero)));
		while (entrada.available()!=0)
			System.out.print((char)entrada.readByte());
	}
}
