package UT1_multiproceso;

import java.io.*;
import java.util.*;

// Este programa crea un proceso de sistema nuevo con un comando y variables de entorno.

public class E03_CmdProcessBuilder {
  public static void main(String args[]) 
     throws InterruptedException,IOException 
  {
    /*
    #!/bin/bash

    #/util/showvar
    #	muestra las variables de entorno que se pasen como argumento

    for VAR in $*
    do
      printf "${VAR}"
      eval VAR="$"$VAR
      printf "\t${VAR}\n"
    done
    */

	ProcessBuilder builder = new ProcessBuilder("/util/showvar","HOSTNAME","PATH","JAVA");
    
    //env contendrá las variables de entorno
    Map<String, String> env = builder.environment();

    env.clear();
    env.put("PATH","/bin:/usr/bin:/sbin:/usr/sbin");
    env.put("HOSTNAME","pepito");
    env.put("JAVA","/opt/java");
    
    //leer entorno: por ejemplo sería env.get("PATH");
    
    final Process p = builder.start();	//crear el proceso
    InputStream is = p.getInputStream();
    InputStreamReader isr = new InputStreamReader(is);
    BufferedReader br = new BufferedReader(isr);
    String line;
    
    System.out.println();  
    System.out.println("Proceso Hijo : ") ;  
    System.out.println("-----------------------");
    
    while ((line = br.readLine()) != null) {
      System.out.println(line);
    }
    
    br.close();
    
    p.waitFor();	//esperar
    
    System.out.println();
    System.out.println("Proceso padre : ") ;  
    System.out.println("-----------------------");
    System.out.println("PATH (desde entorno): "+System.getenv("PATH"));
    
    /* System Properties más info):
    	http://docs.oracle.com/javase/tutorial/essential/environment/sysprop.html
    */
    
    System.out.println("PATH (desde System Properties) : " + System.getProperty("PATH")) ;  
    System.out.println("java.library.path environment variable from System Properties : " + System.getProperty("java.library.path")) ;
    
    System.out.println("Fin!");
  }
}