package UT3_Comunicaciones;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;


//IMPORTANTE:
//En este ejemplo, es el cliente el que lanza al servidor mediante startJavaProcess()
//Este E07_HelloWorldServer NO debe arrancarse si se va a usar E07_HelloWorldClient

public class E07_HelloWorldServer {

    private ServerSocket server;
    private Socket client;
    private BufferedReader in;
    private PrintWriter out;
    private String line;
    private int listenerPort;

    public ServerSocket getServerSocket() {
    	return server;
    }
    
    public E07_HelloWorldServer(int listenerPort) {
        this.listenerPort = listenerPort;
    }

    public void startListening() {
        try {
        	//3 formas sobrecargadas del cosntructor ServerSocket():
        	//	ServerSocket(int port)
        	//	ServerSocket(int port, int numberOfClients)
        	//	ServerSocket(int port, int numberOfClients, InetAddress address)
        	//
            server = new ServerSocket(this.listenerPort,E07_JavaProcessBuilder.MAX_CLIENTS, InetAddress.getLocalHost());
            client = server.accept();  //Esperar cliente
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            out = new PrintWriter(client.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        while (true) {
            try {
                line = in.readLine();
                if (line.equalsIgnoreCase("hello")) {
                    System.out.println("Hello from the server!");
                    out.println("ack");
                    out.flush();
                } else if (line.equalsIgnoreCase("stop")) {
                    try {
                        out.println("ack");
                        out.flush();
                        System.out.println("Client triggered this server to shutdown.");
                        in.close();
                        out.close();
                        server.close();
                        System.exit(0);
                    } catch (IOException e) {
                        System.out.println("Could not close.");
                        System.exit(-1);
                    }
                }
            } catch (IOException e) {
                System.out.println("Read failed");
                System.exit(-1);
            }
        }
    }
    
    public static void main(String[] args) {
    	E07_HelloWorldServer helloWorld=null;
    	try {
    		helloWorld=new E07_HelloWorldServer(E07_JavaProcessBuilder.PUERTO);
    		//
    		helloWorld.startListening();
    	}
	    catch (Exception err) {
		      err.printStackTrace();
		}
    	finally {
    		try {
    			helloWorld.getServerSocket().close();
    		} catch (IOException e) {
    			System.out.println("No se pudo liberar el socket");
    		}
    	}
    }
}
