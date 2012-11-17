package UT0_Repaso;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;

public class WordCount2 {
    
    /**
     * Example method for using the StreamTokenizer class
     */
    public void countWordsAndNumbers(String filename) {
        
        StreamTokenizer sTokenizer = null;
        int wordCount = 0, numberCount = 0;
        
        try {
            
            sTokenizer = new StreamTokenizer(new FileReader(filename));
            
            while (sTokenizer.nextToken() != StreamTokenizer.TT_EOF) {
                
                if (sTokenizer.ttype == StreamTokenizer.TT_WORD)
                    wordCount++;
                else if (sTokenizer.ttype == StreamTokenizer.TT_NUMBER)
                    numberCount++;
            }
            
            System.out.println("Number of words in file: " + wordCount);
            System.out.println("Number of numbers in file: " + numberCount);
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
		for (int i=0; i<args.length; i++) {
			new WordCount2().countWordsAndNumbers(args[i]);
		}
    }
}
