package UT0_Ficheros;

import java.util.*;
import java.util.regex.*;

//Ejemplo de Lista genérica y expresiones regulares

public class Regex {

	public static List<String> separaTokens(String source)
	{
		List<String> result = new ArrayList<String>();
		Pattern CCC_REGEX = Pattern.compile("(\\d{4})[.-]?(\\d{4})[.-]?(\\d{2})[.-]?(\\d{10})");
		Matcher m = CCC_REGEX.matcher(source);
		if (m.matches())
		{
			for (int i=1; i<=m.groupCount(); i++) {	 //group(0) es la cadena completa
				result.add(m.group(i));
			}
		}
		return result;
	}

	public static void main(String[] args) throws Exception
	{
		String[] cuentas = {
				"11998293993817100987",
				"12383783938938939937",
				"88833002020202222221"
				};
		
		for (String c :cuentas) {

			List<String> n=separaTokens(c);
			
			System.out.print("[");
			for (int i=0; i < n.size(); i++)
			    System.out.print(n.get(i)+";");
			System.out.println("]");
		}
	}
}