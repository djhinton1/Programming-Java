import java.util.*;
import java.io.*;

public class Lab4 {
	public static void main(String[] args) throws Exception {
	
		if (args.length < 1 ) {
			System.out.println("\nusage: C:\\> java Project2 <input filename>\n\n"); 
			System.exit(0);
		}//END ERROR TEST


		ArrayList<String> aListString = new ArrayList<String>(); 

		BufferedReader infile = new BufferedReader( new FileReader(args[0]));
		while (infile.ready()){
			String word = infile.readLine(); //get word
			String arranged = canonical(word); //make canonical
			aListString.add(word + " " + arranged); //create array of word + canonical
		}//END WORD LOADING
		
		Collections.sort(aListString);
		printList(aListString);
		
	}//END MAIN
	
	
	
//Canonical Method	
//------------------------------------------------------------------------------------
	private static String canonical(String word){
		char[] arranged = word.toCharArray();
		Arrays.sort(arranged);
	
		return new String(arranged);
	}//END CANONICAL
	
	
//Print List Method
//------------------------------------------------------------------------------------
	private static void printList(ArrayList<String> aListString){
		for(String n : aListString){
			System.out.println(n);
		}//END PRINTINGw
		
		return;
	}//END PRINT LIST
	
}//END CLASS