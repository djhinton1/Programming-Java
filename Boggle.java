import java.io.*;
import java.util.*;


public class Boggle{
	static TreeSet<String> words = new TreeSet<String>();
	static TreeMap<Character, ArrayList<String>> letter;
	static char startLetter;
	static int numWordsFormed = 0;
	
//MAIN METHOD	
//--------------------------------------------------------------------------------		
	public static void main(String[] args) throws Exception{
		words = new TreeSet<String>();
		loadDictionary(args[0]);
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		for(int i = 0; i < 26; i++)
			Collections.sort(letter.get(alphabet.charAt(i)));
		Scanner fromFile = new Scanner(new File(args[1]));
		int rows = fromFile.nextInt();
		int cols = rows;
		String[][] grid = new String[rows][cols];
		for(int i = 0; i < rows; i++){
			for( int k = 0; k < cols; k++){
				grid[i][k] = fromFile.next();e
			}
		}
		fromFile.close();
		int[] dropInPt = new int[2];
		for(int i = 0; i < rows; i++){
			for(int k = 0; k < cols; k++){
			startLetter = grid[i][k].charAt(0);
			DFS(grid, i, k, "");
			}
		}
		for(String s : words)
			System.out.println(s);
	}//END MAIN
	
//DICTIONARY LOADER	METHOD
//--------------------------------------------------------------------------------	
	static void loadDictionary(String arg) throws Exception{
		letter = new TreeMap<Character, ArrayList<String>>();
		BufferedReader infile = new BufferedReader( new FileReader(arg) );
			while ( infile.ready() ){
				String word = infile.readLine();
				if(letter.containsKey(word.charAt(0)))
					letter.get(word.charAt(0)).add(word);
				else
					letter.put(word.charAt(0), new ArrayList<String>());
			} //END WHILE INFILE READY
		infile.close();		
	}
	
	

//DFS METHOD	
//--------------------------------------------------------------------------------		
	static void DFS( String[][] grid, int r, int c, String word) {	
		word += grid[r][c];
		numWordsFormed++;
		if(word.length() > 2){
			int index = Collections.binarySearch(letter.get(startLetter), word);
			if(index >= 0){
				words.add(word);
			}
			else{
				if(-index-1 < letter.get(startLetter).size())
					if(!(letter.get(startLetter).get(-index-1).startsWith(word))){
   						return;
   					}
			}
		}
		
		
			if(r-1 >= 0 & r-1 < grid.length & c >= 0 & c < grid.length){
				if(Character.isLowerCase(grid[r-1][c].charAt(0))){
					grid[r][c]=grid[r][c].toUpperCase();
					DFS(grid,r-1,c,word);
					grid[r][c]=grid[r][c].toLowerCase();
				}
			}
			if(r-1 >= 0 & r-1 < grid.length & c+1 >= 0 & c+1 < grid.length){
				if(Character.isLowerCase(grid[r-1][c+1].charAt(0))){
					grid[r][c]=grid[r][c].toUpperCase();
					DFS(grid,r-1,c+1,word);
					grid[r][c]=grid[r][c].toLowerCase();
				}
			}
			if(r >= 0 & r < grid.length & c+1 >= 0 & c+1 < grid.length){
				if(Character.isLowerCase(grid[r][c+1].charAt(0))){
					grid[r][c]=grid[r][c].toUpperCase();
					DFS(grid,r,c+1,word);
					grid[r][c]=grid[r][c].toLowerCase();
				}
			}
			if(r+1 >= 0 & r+1 < grid.length & c+1 >= 0 & c+1 < grid.length){
				if(Character.isLowerCase(grid[r+1][c+1].charAt(0))){
					grid[r][c]=grid[r][c].toUpperCase();
					DFS(grid,r+1,c+1,word);
					grid[r][c]=grid[r][c].toLowerCase();
				}
			}
			if(r+1 >= 0 & r+1 < grid.length & c >= 0 & c < grid.length){
				if(Character.isLowerCase(grid[r+1][c].charAt(0))){
					grid[r][c]=grid[r][c].toUpperCase();
					DFS(grid,r+1,c,word);
					grid[r][c]=grid[r][c].toLowerCase();
				}
			}
			if(r+1 >= 0 & r+1 < grid.length & c-1 >= 0 & c-1 < grid.length){
				if(Character.isLowerCase(grid[r+1][c-1].charAt(0))){
					grid[r][c]=grid[r][c].toUpperCase();
					DFS(grid,r+1,c-1,word);
					grid[r][c]=grid[r][c].toLowerCase();
				}
			}
			if(r >= 0 & r < grid.length & c-1 >= 0 & c-1 < grid.length){
				if(Character.isLowerCase(grid[r][c-1].charAt(0))){
					grid[r][c]=grid[r][c].toUpperCase();
					DFS(grid,r,c-1,word);
					grid[r][c]=grid[r][c].toLowerCase();
				}
			}
			if(r-1 >= 0 & r-1 < grid.length & c-1 >= 0 & c-1 < grid.length){
				if(Character.isLowerCase(grid[r-1][c-1].charAt(0))){
					grid[r][c]=grid[r][c].toUpperCase();
					DFS(grid,r-1,c-1,word);
					grid[r][c]=grid[r][c].toLowerCase();
				}
			}
		return;
	}//END DFS
}//END CLASS

