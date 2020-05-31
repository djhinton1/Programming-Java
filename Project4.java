import java.util.*;
import java.io.*;

public class Project4{
	public static void main(String[] args) throws Exception {

		if (args.length < 1 ) {
			System.out.println("\nusage: C:\\> java Project2 <input filename>\n\n"); 
			System.exit(0);
		}//END ERROR TEST
		
		
		ArrayList<String> aListDictionary = readFile(args[0]);
		ArrayList<String> aListJumbles= readFile(args[1]); 

		String[] dArray = aListDictionary.toArray(new String[aListDictionary.size()]);
        String[] jArray = aListJumbles.toArray(new String[aListJumbles.size()]);
        

		 for(int i = 0 ; i < aListJumbles.size() ; i++){
            String jWord = canonical(jArray[i]);
            System.out.print(aListJumbles.get(i) + " ");
            
            for(int k = 0 ; k < aListDictionary.size() ; k++){
                String dWord = canonical(dArray[k]);
                
                if(jWord.equals(dWord)){
                    System.out.print(aListDictionary.get(k) + " ");
                }

            }
            System.out.println();
        }	
	}//END MAIN
	
	
	
//Read File Method
//------------------------------------------------------------------------------------
	private static ArrayList<String> readFile (String filename) throws Exception {
	
		ArrayList<String> aListNew = new ArrayList<String>();
		BufferedReader infile = new BufferedReader( new FileReader(filename));
		while (infile.ready()){
			String word = infile.readLine(); //get word
			aListNew.add(word); //create array
			}
		Collections.sort(aListNew);
	
		return (aListNew);
		
	}//END READ FILE
		
	
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