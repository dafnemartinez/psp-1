package UT1_multiproceso;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class HelloWorldServer {

    private ServerSocket server;
    private Socket client;
    private BufferedReader in;
    private PrintWriter out;
    private String line;
    private int listenerPort;

    public HelloWorldServer(int listenerPort) {
        this.listenerPort = listenerPort;
    }

    public void startListening() {
        try {
            server = new ServerSocket(this.listenerPort);
            client = server.accept();
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
    
    //Recoge el binding port de args (18766)

    public static void main(String[] args) {
        final HelloWorldServer helloWorld = new HelloWorldServer(Integer.parseInt(args[0]));
        helloWorld.startListening();
    }
}
