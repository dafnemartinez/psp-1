package UT1_multiproceso;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class JavaProcessBuilderTests {

    private static final int LISTENER_PORT = 18766;
    private static final String CLASSPATH = "./out/production/ForkingJavaProcesses";
    private static final String WORKING_DIRECTORY = ".";
 
    public void startJavaProcess() throws Exception {
        final JavaProcessBuilder javaProcessBuilder = new JavaProcessBuilder();
        if (System.getProperty("os.name").toLowerCase().equals("mac os x")) {
            javaProcessBuilder.setJavaRuntime("/System/Library/Frameworks/JavaVM.framework/Versions/1.6/Home/bin/java");
        }
        javaProcessBuilder.setWorkingDirectory(WORKING_DIRECTORY);
        javaProcessBuilder.addClasspathEntry(CLASSPATH);
        javaProcessBuilder.setMainClass("examples.forkingjavaprocesses.HelloWorldServer");
        javaProcessBuilder.addArgument(String.valueOf(LISTENER_PORT));
        final Process process = javaProcessBuilder.startProcess();
        BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));

        Thread t = new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(1000);
                    Socket socket = new Socket("localhost", LISTENER_PORT);
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

        String line;
        while ((line = br.readLine()) != null) {
            System.out.println("SERVER: " + line);
        }
    }
    
    public static void main(String [] args)
    {
    	JavaProcessBuilderTests t=new JavaProcessBuilderTests();
    	try
    	{
    		t.startJavaProcess();
    	} catch (Exception e) {
    		System.out.println(e.getMessage());
    	}
    }
}
