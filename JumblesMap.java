import java.util.*;
import java.io.*;

public class JumblesMap{
	static TreeMap<String, String> words = new TreeMap<String, String>();
	static ArrayList<String> finalWords = new ArrayList<String>();

//MAIN METHOD
//------------------------------------------------------------------------------------
	public static void main(String args[])throws Exception{
		if (args.length < 1 ) {
			System.out.println("\nusage: C:\\> java Project2 <input filename>\n\n"); 
			System.exit(0);
		}
		loadJumbles(args[1]);
		loadDictionary(args[0]);
		Iterator<String> theCanonicals = words.keySet().iterator();
		while(theCanonicals.hasNext()){
			String s = theCanonicals.next();
			finalWords.add(words.get(s));
		}
		Collections.sort(finalWords);
		for(String N : finalWords)
			System.out.println(N);
	}//END MAIN METHOD


//JUMBLES LOADER METHOD
//--------------------------------------------------------------------------------	
	static void loadJumbles(String arg) throws Exception{
		BufferedReader infile = new BufferedReader( new FileReader(arg) );
			while (infile.ready()){
				
				String jword = infile.readLine();
				String canonWord = canonical(jword);
				words.put(canonWord, new String());
				words.put(canonWord, words.get(canonWord) + jword + " ");
				
			} //END WHILE INFILE READY
		infile.close();		
	}//END JUMBLES LOADER
	
	
//DICTIONARY LOADER METHOD
//--------------------------------------------------------------------------------
	static void loadDictionary(String arg) throws Exception{
		BufferedReader infile = new BufferedReader( new FileReader(arg) );
		ArrayList<String> dictionary = new ArrayList<String>();
			while (infile.ready()){
				dictionary.add(infile.readLine());
			} //END WHILE INFILE READY
		infile.close();
		Collections.sort(dictionary);
		for(String K : dictionary){
			String canonWord = canonical(K);
			if(words.containsKey(canonWord))
				words.put(canonWord, words.get(canonWord) + K + " ");
		}
	}//END DICTIONARY LOADER

	
//CANONICAL METHOD	
//------------------------------------------------------------------------------------
	private static String canonical(String word){
		char[] arranged = word.toCharArray();
		Arrays.sort(arranged);
		return new String(arranged);
	}//END CANONICAL
}//END CLASS