package UT3_Comunicaciones;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;



//IMPORTANTE:
// * En este ejemplo, es el cliente el que lanza al servidor mediante startJavaProcess()
// * Se combinan procesos e hilos

public class E07_HelloWorldClient {

    private static final String CLASSPATH = "./bin";
    private static final String WORKING_DIRECTORY = ".";
 
    public void startJavaProcess() throws Exception {
    	
    	
    	//Todo este bloque es para crear el proceso del servidor  ...
        final E07_JavaProcessBuilder e07_JavaProcessBuilder = new E07_JavaProcessBuilder();
        if (System.getProperty("os.name").toLowerCase().equals("mac os x")) {
            e07_JavaProcessBuilder.setJavaRuntime("/System/Library/Frameworks/JavaVM.framework/Versions/1.6/Home/bin/java");
        }
        e07_JavaProcessBuilder.setWorkingDirectory(WORKING_DIRECTORY);
        e07_JavaProcessBuilder.addClasspathEntry(CLASSPATH);
        e07_JavaProcessBuilder.setMainClass("UT1_multiproceso.HelloWorldServer");
        e07_JavaProcessBuilder.addArgument(String.valueOf(E07_JavaProcessBuilder.PUERTO));
        final Process process = e07_JavaProcessBuilder.startProcess();
        
        // ...hasta aquí
        
        BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));

        //Este hilo para que el cliente mande comandos al servidor
        Thread t = new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(1000);
                    Socket socket = new Socket("localhost", E07_JavaProcessBuilder.PUERTO);
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    System.out.println("CLIENT: Sending 'hello' command.");
                    out.println("hello");
                    System.out.println("CLIENT: Received '" + in.readLine() + "' from the server.");
                    Thread.sleep(2000);
                    System.out.println("CLIENT: Sending 'stop' command.");
                    out.println("stop");
                    System.out.println("CLIENT: Received '" + in.readLine() + "' from the server.");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();

        //El hilo "main" para que mostrar los mensajes del servidor, leidos mediante br, que recoge 
        //la salida estándar del proceso Server.
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println("SERVER: " + line);
        }
    }
    
    public static void main(String [] args)
    {
    	E07_HelloWorldClient t=new E07_HelloWorldClient();
    	try
    	{
    		t.startJavaProcess();
    	} catch (Exception e) {
    		System.out.println(e.getMessage());
    	}
    }
}
