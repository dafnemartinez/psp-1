package UT3_Comunicaciones;

import java.io.*;
import java.net.*;

public class E01_EchoClient {
    public static void main(String[] args) throws IOException {
    	String host="localhost";
        Socket echoSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;
        try {
            echoSocket = new Socket(host, 22);		//puerto ssh
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(
                                        echoSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Host desconocido: "+host);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("No se pudo abrir E/S a: "+host);
            System.exit(1);
        }

	BufferedReader stdIn = new BufferedReader(
                                   new InputStreamReader(System.in));
	String userInput;

	while ((userInput = stdIn.readLine()) != null) {
	    out.println(userInput);
	    System.out.println("echo: " + in.readLine());
	}

	out.close();
	in.close();
	stdIn.close();
	echoSocket.close();
    }
}