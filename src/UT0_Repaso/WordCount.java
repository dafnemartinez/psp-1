package UT0_Repaso;

import java.io.*;

class WordCount {
	public static int words=0;
	public static int lines=0;
	public static int chars=0;
	public static void wc (InputStream f) throws IOException {
		int c=0;
		boolean lastNotWhite=false;
		String whiteSpace=" \t\n\r";
		while ((c=f.read())!=-1 ) {
			chars++;
			if (c=='\n')
				lines++;
			if (whiteSpace.indexOf(c)!=-1) {
				if (lastNotWhite)
					words++;
				lastNotWhite=false;
			}
			else
				lastNotWhite=true;
		}
	}
	
	public static void main(String [] args) {
		BufferedInputStream f;
		try {
			if (args.length==0) {
				f=new BufferedInputStream(System.in);
				wc(f);
			}
			else
				for (int i=0; i<args.length; i++) {
					f=new BufferedInputStream(new FileInputStream(args[i]));
					wc(f);
				}
		}
		catch (IOException e) {
			return;
		}
		System.out.println(lines+" "+words+" "+chars);
	}
}
