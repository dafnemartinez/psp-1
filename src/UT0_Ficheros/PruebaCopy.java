package UT0_Ficheros;

import java.io.*;
import java.nio.channels.FileChannel;

public class PruebaCopy {

	public static void copyFile(File sourceFile, File destFile) 
			throws IOException {
		if(!destFile.exists()) {
			destFile.createNewFile();
		}

		FileChannel source = null;
		FileChannel destination = null;

		try {
			source = new FileInputStream(sourceFile).getChannel();
			destination = new FileOutputStream(destFile).getChannel();
			destination.transferFrom(source, 0, source.size());
		}
		finally {
			if(source != null)
				source.close();
			if(destination != null)
            	destination.close();
        }
	}
	
	public static void main (String [] args) {
		if (args.length!=2)
			System.out.println("origen destino");
		else
		{
			File fo=new File(args[0]);
			File fd=new File(args[1]);
			try
			{
				PruebaCopy.copyFile(fo,fd);
			}
			catch (IOException e)
			{
				System.out.println(e.getMessage());
			}
			finally
			{
			}
		}

	}
}