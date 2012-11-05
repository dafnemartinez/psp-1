package UT1_multiproceso;

import java.io.*;
import java.util.*;

// Este programa crea un proceso de sistema nuevo con un comando "pwd" y variables de entorno.

public class E02_CmdProcessBuilder {
  public static void main(String args[]) 
     throws InterruptedException,IOException 
  {
    List<String> command = new ArrayList<String>();
    command.add("/bin/pwd");		//aquí un comando sin parámetros

    ProcessBuilder builder = new ProcessBuilder(command);
    Map<String, String> env = builder.environment();

    env.clear();
    env.put("PATH","/bin:/usr/bin:/sbin:/usr/sbin");
    env.put("HOSTNAME","localhost");
    
    final Process process = builder.start();	//crear el proceso
    InputStream is = process.getInputStream();
    InputStreamReader isr = new InputStreamReader(is);
    BufferedReader br = new BufferedReader(isr);
    String line;
    while ((line = br.readLine()) != null) {
      System.out.println(line);
    }
    System.out.println("Program terminated!");
  }
}