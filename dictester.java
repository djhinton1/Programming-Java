import java.io.*;
import java.util.*;

public class dictester{
	public static void main(String args[]) throws Exception{
	
	
		TreeMap<Character, TreeSet<String>> letter = new TreeMap<Character, TreeSet<String>>();
		
		BufferedReader infile = new BufferedReader( new FileReader("dictionary.txt") );
			while ( infile.ready() ){
				String word = infile.readLine();
				if(letter.containsKey(word.charAt(0)))
					letter.get(word.charAt(0)).add(word);
				else
					letter.put(word.charAt(0), new TreeSet<String>());
					
				
			
			} //END WHILE INFILE READY
		infile.close();		
	}//END MAIN
}//END CLASS