int[][] grid = new int[3][4];//[rows][cols]
//grid.length = # of rows
//grid[i].length = length of ith row (cols if the matrix is uniform)

//how do you find the first step: need to look as the cells around from N to NW
//are you a 1? are you a 1? are you a 1? Yes? GOOD.
//print where the 1 is and then set your current location to where that 1 is.
//make sure you mark where you have been (make old space a -1)

//while my current location is not on the edge of the swamp (this is the outer loop)
//4 possibilities:
//r = 0
//c = 0
//r = matrix.length -1
//c = matrix[c].length - 1
//sometimes there will be dead ends where there are multiple 1s around a location
//in this case, recursion will be necessary
//advance forward, if it is a dead end, then go back
//clone is a sweep of the neighbors
//passing in a slightly different row and col
//if we return all the way back home, then we have exited the scary swamp


/*

static void DFS (swamp, r, c, path)/
while (r != swamp.length-1 || c != swamp.length-1){

	if(swamp[r-1][c] == 1){ //test for northern neighbor
		blah blah
	}
	else if (swamp[r-1][c+1] == 1){
		//if it is safe, then
		swamp[r][c] = -1;
		r = r-1;
		c = c+1;
		
	}
	else if (swamp[r][c+1] == 1){
		blah blah 
	}
	//there are going to be 8 of these cases
	else{//this is the case that you'll need to backtrack
		
	}
}


//RECURSIVE METHOD
//------------------------------------------------------------------------
public static void DFS(swamp, r, c, path){
	path += "[r,c]" //print the path, concatenate the path you took
	if (r = swamp.length-1 || c = swamp.length-1){
		System.out.println(path);
		return;
	}
	else{ //this is where the 8 different cases go
		//each case contains the following: each case is an "if" statement not an "else if"
		
		{swamp[r][c] = -1; //mark current spot
		DFS(swamp, r-1, c, path); //will change based on which case
		swamp[r][c] = 1;}
		
	}
	return;
}
*/









