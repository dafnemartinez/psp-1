package UT3_Comunicaciones;

import java.net.*;

public class C01_InetAddressDemo {
	public static void main(String args[]) throws UnknownHostException {
		InetAddress a=InetAddress.getLocalHost();
		System.out.println(a);
		a=InetAddress.getByName("www.google.com");
		System.out.println(a);
		InetAddress i4[]=InetAddress.getAllByName("www.yahoo.com");
		for (int i=0; i<i4.length; i++)
			System.out.println(i4[i]);
	}
	
}
