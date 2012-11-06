package UT3_Comunicaciones;

import java.net.*;
import java.io.*;
 
public class E05_KKMultiServerThread extends Thread {
    private Socket socket = null;
 
    public E05_KKMultiServerThread(Socket socket) {
    super("E05_KKMultiServerThread");
    this.socket = socket;
    }
 
    public void run() {
 
    try {
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                    socket.getInputStream()));
 
        String inputLine, outputLine;
        E06_KnockKnockProtocol kkp = new E06_KnockKnockProtocol();
        outputLine = kkp.processInput(null);
        out.println(outputLine);
 
        while ((inputLine = in.readLine()) != null) {
        outputLine = kkp.processInput(inputLine);
        out.println(outputLine);
        if (outputLine.equals("Bye"))
            break;
        }
        out.close();
        in.close();
        socket.close();
 
    } catch (IOException e) {
        e.printStackTrace();
    }
    }
}