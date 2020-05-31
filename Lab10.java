import java.io.*;
import java.util.*;

public class Lab10{
	public static void main(String[] args) throws Exception{
		
		String uniqueness = unique(args);
		System.out.println(uniqueness);
		
	}//END MAIN
	
	static String unique(String[] args) throws Exception{
		
		BufferedReader infile = new BufferedReader( new FileReader(args[0]));
		HashSet<String> theWords = new HashSet<String>();
		while (infile.ready()){
			String word = infile.readLine(); 
			if (theWords.contains(word))
				return("NOT UNIQUE");
			else
				theWords.add(word);
		}//END READER WHILE LOOP
		return("UNIQUE");
		
	}//END UNIQUE
}//END LAB10