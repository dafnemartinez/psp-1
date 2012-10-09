package UT0_Evaluación_Inicial;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ej2_TablaMultiplicar {

	private static BufferedReader br;

	public static void main(String[] args) throws IOException {

		br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Introduca el numero a sacar la tabla:");
		String n=br.readLine();
		for (int i=0; i<=10 ; i++){
			int t=Integer.parseInt(n) * i;
			System.out.println(n+" * " + i + " = " + t);
		}
	}
}
