package UT3_Comunicaciones;

import java.net.*;

public class C01_InetAddressDemo {
	public static void main(String args[]) throws UnknownHostException {
		byte b[]=new byte [] {(byte)172,(byte)16,(byte)14,(byte)99};
		
		InetAddress a=InetAddress.getLocalHost();
		System.out.println(a);
		a=InetAddress.getByName("www.google.com");
		System.out.println(a);
		a=InetAddress.getByName("172.20.254.104");
		System.out.println(a);
		System.out.println("getCanonicalHostName()="+a.getCanonicalHostName());
		System.out.println("getHostAddress()="+a.getHostAddress());
		System.out.println("getHostName()="+a.getHostName());
		System.out.println("toString()="+a.toString());
		System.out.println("getClass()="+a.getClass());
		System.out.println("isAnyLocalAddress()="+a.isAnyLocalAddress());
		System.out.println("isLinkLocalAddress()="+a.isLinkLocalAddress());
		System.out.println("isLoopbackAddress()="+a.isLoopbackAddress());
		System.out.println("isMCGlobal()="+a.isMCGlobal());
		System.out.println("isMCLinkLocal()="+a.isMCLinkLocal());
		System.out.println("isMCNodeLocal()="+a.isMCNodeLocal());
		System.out.println("isMCOrgLocal()="+a.isMCOrgLocal());
		System.out.println("isMCSiteLocal()="+a.isMCSiteLocal());
		System.out.println("isMulticastAddress()="+a.isMulticastAddress());
		System.out.println("isSiteLocalAddress()="+a.isSiteLocalAddress());
		try {
		System.out.println("isReachable()="+a.isReachable(0));
		} catch (Exception e) {};
		System.out.println("InetAddress.getByAddress()="+InetAddress.getByAddress(b));

		InetAddress aa[]=InetAddress.getAllByName("www.yahoo.com");
		for (int i=0; i<aa.length; i++)
			System.out.println(aa[i]);
	}
	
}
