package UT9;

import java.io.*;

//captura la salida (stdio) de un proceso externo

public class E99_ExecuteImproved {

	public static void main(String args[]) {
		try {
			final int TIEMPO_ESPERA=5000;
			final int numProcs=args.length;
			Process[] procesos = new Process[numProcs];	//vector de procesos hijos, uno por arg
			BufferedReader[] in = new BufferedReader[numProcs];	//vector de entradas
			BufferedReader[] err = new BufferedReader[numProcs];	//vector de errores
			Integer[] retcode = new Integer[numProcs];  //vector de retornos

			//bucle de creación de procesos y flujos
			//OJITO: se ejecutan en paralelo con el programa principal
			for (int i = 0; i < numProcs; i++) {
				//ejecutar "exec()" y guardar el runtime del proceso "getRunTime()"
				procesos[i] = Runtime.getRuntime().exec(args[i]);

				//asignar los BufferedReader para in y err
				in[i] = new BufferedReader(new InputStreamReader(
						procesos[i].getInputStream()));
				err[i] = new BufferedReader(new InputStreamReader(
						procesos[i].getErrorStream()));
			}

			//bucle para mostrar la salida producida por los procesos  y conservar retcode
			for (int i = 0; i < numProcs; ++i) {
				String linea;
				//leer de entrada y mostrar en pantalla
				while ((linea = in[i].readLine()) != null)
					System.out.println(linea);
				in[i].close();

				//leer de error
				while ((linea = err[i].readLine()) != null)
					System.out.println(linea);
				err[i].close();

				retcode[i] = procesos[i].exitValue();	//ver retorno
			}

			System.out.println("Durmiendo "+TIEMPO_ESPERA+" ms");
			Thread.sleep(TIEMPO_ESPERA);
			System.out.println("¡Despertando!");

			//bucle para matar a procesos hijos (que ya han debido morirse solos) y reunirse con sus almas
			for (int i = 0; i < numProcs; ++i) {
				procesos[i].destroy();					//muerte preventiva, deben morirse solitos
				procesos[i].waitFor(); 					//esperar reunión hijo difunto
			}
			
			//bucle para mostrar retcodes
			for (int i = 0; i < numProcs; ++i)
				System.out.println(args[i]+ " --> retcode="+ retcode[i]);

			System.out.println("Fin.");
		} catch (Exception err) {
			err.printStackTrace();
		}
	}
}
