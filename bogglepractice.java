/*

NEEDED DATA STRUCTURES
1.) Store Dictionary: hashset (does this really need to be sorted?)
2.) Store Hits (matches): treeset

dont want to store a list of every formed string

*/

public void DFS( board, r, c, word){ //the word here is the "path"

there are 8 of these for each directional case (N, NW, W,...)
-------------------------------------------------
	word = word + board[r][c];
	have to make sure that changing the direction is not out of
	bounds
	//---> is the word in the dictionary?
	if (yes){
		//store in match set
	}
	else (no){
		//see if it is a prefix
		if (yes){
			call DFS
		}
		else (no){
			return;
		}
	}
--------------------------------------------------	

}


