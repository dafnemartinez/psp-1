package UT0_Repaso;

import java.util.regex.*;

public class CCC {

	private String entidad,oficina,dc1,dc2,cuenta;
	private static final Pattern CCC_REGEX =
			Pattern.compile("(\\d{4})[.-]?(\\d{4})[.-]?(\\d{1})(\\d{1})[.-]?(\\d{10})");
	public static final String sep=".";			//separador por defecto
	public static int p1 [] = {4, 8, 5, 10, 9, 7, 3, 6};
	public static int p2 [] = {1, 2, 4, 8, 5, 10, 9, 7, 3, 6};

	CCC(String source) throws Exception {
		Matcher m = CCC_REGEX.matcher(source);
		if (m.matches())
		{
			entidad=m.group(1);
			oficina=m.group(2);
			dc1=m.group(3);
			dc2=m.group(4);
			cuenta=m.group(5);
			
			String entiofi=entidad+oficina;
			
		    int dc1=0, dc2=0;
		    
		    for (int i=0; i<p1.length; i++)
		    	dc1+=Integer.parseInt(entiofi.substring(i,i+1))*p1[i];
		 
		    dc1=dc1 %11;
		    dc1=11-dc1;
		    if (dc1==10) {
		        dc1=1;
		    }
		    if (dc1==11) {
		        dc1=0;
		    }    

		    for (int i=0; i<p2.length; i++)
		    	dc2+=Integer.parseInt(cuenta.substring(i,i+1))*p2[i];
		 
		    dc2=dc2 %11;
		    dc2=11-dc2;
		    if (dc2==10) {
		        dc2=1;
		    }
		    if (dc2==11) {
		        dc2=0;
		    }    
		    
		    if (dc1 != Integer.parseInt(this.dc1))
		    	throw new Exception("DC1 incorrecto");
		    if (dc2 != Integer.parseInt(this.dc2))
		    	throw new Exception("DC2 incorrecto");
		}
		else
			throw new Exception("CCC incorrecto");
	}

	public void print(){
		System.out.print(entidad+sep+oficina+sep+dc1+dc2+sep+cuenta);
	}

	public void println() {
		print();
		System.out.println();
	}


	public static void main(String[] args) throws Exception
	{
		String[] cuentas = {
				"0065.1107.55.00029999",
		};

		for (String c :cuentas) {
			try{
				new CCC(c).println();
			} catch (Exception e) {System.out.println(e.getMessage()); }
		}
	}
}