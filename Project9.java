import java.io.*;
import java.util.*;

// DO NOT!! IMPORT JAVA.LANG

public class Project9
{

	private static int[][] loadSwamp( String infileName, int[] dropInPt  ) throws Exception
	{
		Scanner fromFile = new Scanner(new File(infileName));
		int rows = fromFile.nextInt();
		int cols = rows;
		dropInPt[0] = fromFile.nextInt();
		dropInPt[1] = fromFile.nextInt();
		
		int[][] Swamp = new int[rows][cols];
		
		for(int i = 0; i < rows; i++){
			for( int k = 0; k < cols; k++){
				Swamp[i][k] = fromFile.nextInt();
			}
		}
		fromFile.close();
		return Swamp;
	}
	public static void main(String[] args) throws Exception
	{
		int[] dropInPt = new int[2];
		int[][] swamp = loadSwamp( args[0], dropInPt );
		int row=dropInPt[0], col = dropInPt[1];		
		String path = "";
		depthFirstSearch( swamp, row, col, path );
	} // END MAIN

	static void depthFirstSearch( int[][] swamp, int r, int c, String path )
	{
		path += ("[" + r + "," + c + "]");
		if (r == swamp.length-1 | c == swamp.length-1 | r == 0 | c == 0){
			System.out.println(path);
			return;
		}
		else{
			if(swamp[r-1][c] == 1){
				swamp[r][c] = -1;//mark current spot
				depthFirstSearch(swamp,r-1,c,path);
				swamp[r][c] = 1;
			}
			if(swamp[r-1][c+1] == 1){
				swamp[r][c] = -1;
				depthFirstSearch(swamp,r-1,c+1,path);
				swamp[r][c] = 1;
			}
			if(swamp[r][c+1] == 1){
				swamp[r][c] = -1;
				depthFirstSearch(swamp,r,c+1,path);
				swamp[r][c] = 1;
			}
			if(swamp[r+1][c+1] == 1){
				swamp[r][c] = -1;
				depthFirstSearch(swamp,r+1,c+1,path);
				swamp[r][c] = 1;
			}
			if(swamp[r+1][c] == 1){
				swamp[r][c] = -1;
				depthFirstSearch(swamp,r+1,c,path);
				swamp[r][c] = 1;
			}
			if(swamp[r+1][c-1] == 1){
				swamp[r][c] = -1;
				depthFirstSearch(swamp,r+1,c-1,path);
				swamp[r][c] = 1;
			}
			if(swamp[r][c-1] == 1){
				swamp[r][c] = -1;
				depthFirstSearch(swamp,r,c-1,path);
				swamp[r][c] = 1;
			}
			if(swamp[r-1][c-1] == 1){
				swamp[r][c] = -1;
				depthFirstSearch(swamp,r-1,c-1,path);
				swamp[r][c] = 1;
			}
		return;
		}//endELSE
	} // END DFS
}
