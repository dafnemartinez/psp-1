package UT3_Comunicaciones;

import java.net.*;
import java.io.*;

public class C02_SocketDemo {
	public static void main(String args[]) throws Exception {
		int c;
		Socket s=null;
		//Crear socket a destino remoto
		try {
		   s=new Socket("whois.internic.net",43);
		} catch (ConnectException e) {System.out.println("No se pudo conectar"); };

		//Obtener flujos de E/S
		InputStream in=s.getInputStream();
		OutputStream out=s.getOutputStream();

		//Construir petición en formato apropiado
		String str=(args.length==0? "=google.com":args[0])+"\n";

		//Convertir a bytes
		byte buf[]=str.getBytes();

		//Enviar petición
		out.write(buf);

		//Leer y mostrar la respuesta
		while ((c=in.read())!=-1)
			System.out.print((char)c);
		s.close();
	}
}
