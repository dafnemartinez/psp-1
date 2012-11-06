package UT3_Comunicaciones;

import java.io.*;
import java.net.*;
 
public class E06_KnockKnockClient {
    public static void main(String[] args) throws IOException {
 
        Socket kkSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;
        String host="localhost";
 
        try {
            kkSocket = new Socket(host, 4444);
            out = new PrintWriter(kkSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(kkSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Host desconocido: "+host);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("No se pudo abrir E/S "
                               + "a : "+host);
            System.exit(1);
        }
 
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        String fromServer;
        String fromUser;
 
        while ((fromServer = in.readLine()) != null) {
            System.out.println("Servidor: " + fromServer);
            if (fromServer.equals("Adiós."))
                break;
             
            fromUser = stdIn.readLine();
        if (fromUser != null) {
                System.out.println("Cliente: " + fromUser);
                out.println(fromUser);
        }
        }
 
        out.close();
        in.close();
        stdIn.close();
        kkSocket.close();
    }
}
