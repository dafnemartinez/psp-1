package UT2_Multihilo;

public class Hilos04 {

    // Muestra un mensaje precedido con el nombre el hilo actual
    static void threadMessage(String message) {
        String threadName =
            Thread.currentThread().getName();
        System.out.format("%s: %s%n",
                          threadName,
                          message);
    }

    private static class MessageLoop implements Runnable {
    	
        public void run() {
            String importantInfo[] = {
                "Pues ya ves",
                "por aquí andamos",
                "pasando el rato",
                "sin nada mejor que hacer"
            };
            try {
                for (int i = 0;
                     i < importantInfo.length;
                     i++) {
                    // Pause for 4 seconds
                    Thread.sleep(4000);
                    // Print a message
                    threadMessage(importantInfo[i]);
                }
            } catch (InterruptedException e) {
                threadMessage("Me interrumpieron!");
            }
        }
    }

    public static void main(String args[])
        throws InterruptedException {

        // Retraso hasta que interrumpamos al hilo de mensajes
        // Por defecto 10 segundos
        long patience = 1000 * 10;

        // Si se pasa en la linea de comandos, modificar la espera
        if (args.length > 0) {
            try {
                patience = Long.parseLong(args[0]) * 1000;
            } catch (NumberFormatException e) {
                System.err.println("Debe ser un entero largo!");
                System.exit(1);
            }
        }

        threadMessage("Arrancando el hilo...");
        long startTime = System.currentTimeMillis();
        Thread t = new Thread(new MessageLoop());	//creamos un Hilo, pero no de la clase Hilos04, sino MessageLoop
        t.start();

        threadMessage("Esperando a que termine el bucle de mensajes");
        while (t.isAlive()) {	//el hilo sigue vivo
            threadMessage("Esperando...");
            //Esperar la reunión del hilo un máximo de un segundo
            t.join(1000);
            if (((System.currentTimeMillis() - startTime) > patience)	//si hemos excedido el t. total y el hilo sigue
                  && t.isAlive()) {
                threadMessage("Main Thread dice que se acabó la espera!");
                t.interrupt();
                // Esperando la reunión definitiva, no debe tardar
                t.join();
            }
        }
        threadMessage("Fin!");
    }
}