package UT3_Comunicaciones;

import java.net.*;

public class C03_URL {
	public static void main(String args[]) throws MalformedURLException {
		String rutas[]=new String[] {
				"http://www.ibm.com:443/index.html",
				"ftp://www.microsoft.com"
		};

		for (String ruta: rutas) {
			URL url=new URL(ruta);
			System.out.print("URL="+url);
			System.out.println("getProtocol(): "+url.getProtocol());
			System.out.println("getPort(): "+url.getPort());
			System.out.println("getHost(): "+url.getHost());
			System.out.println("getFile(): "+url.getFile());
			System.out.println("toExternalForm(): "+url.toExternalForm()); //Construye String
			System.out.println();
		}
	}
}
