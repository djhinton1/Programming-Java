/* Project3.java  InsertInOrder with bSearch optimization to compute insertion index */
// STUDENT STARTER FILE
// YOUR NAME/ID:


import java.util.*;
import java.io.*;

public class Project3
{
	static final int INITIAL_CAPACITY = 5;

	public static void main( String args[] ) throws Exception
	{
		if (args.length < 1 )
		{
			System.out.println("ERROR: Must enter an int on cmd line (i.e. # of random ints to put in array)\n");
			System.exit(0);
		}

		int numInts2generate = Integer.parseInt( args[0] );

		// WE USE Random number generator to fill our array

		Random randGen =  new Random( 17 ); // SEED with 17
		int[] arr = new int[INITIAL_CAPACITY];
		int count= 0;
		for ( int i = 0 ; i<numInts2generate ; ++i)
		{
			if ( count==arr.length ) arr = upSizeArr(arr);
			insertInOrder( arr, count++, 1 + randGen.nextInt(1000) );
		}

		arr=trimArr(arr,count); // Now count == .length
		printArray( arr );  // we trimmed it thus count == length so we don't bother to pass in count

	} // END MAIN

	// ############################################################################################################

	static void printArray( int[] arr  )
    {
        for( int i=0 ; i<arr.length ;++i )
            System.out.print(arr[i] + " " );
        System.out.println();
    }

	static int[] upSizeArr( int[] fullArr )
	{
		int[] upSizedArr = new int[ fullArr.length * 2 ];
		for ( int i=0; i<fullArr.length ; ++i )
			upSizedArr[i] = fullArr[i];
		return upSizedArr;
	}

	static int[] trimArr( int[] oldArr, int count )
	{
		int[] trimmedArr = new int[ count ];
		for ( int i=0; i<count ; ++i )
			trimmedArr[i] = oldArr[i];
		return trimmedArr;
	}

	
	static void insertInOrder( int[] arr, int count, int newVal   )
	{
		int index = bSearch( arr, count, newVal );
		index = -index - 1;	
		for(int i = (count - 1); i >= index; i-=1) {
			arr[i+1] = arr[i];
		}
		arr[index] = newVal;
	}

	
	static int bSearch(int[] arr, int count, int key)
	{	
		int lo = 0, hi = count - 1, mid;

		
		while (lo <= hi){
		 	mid = lo + ((hi - lo)/2);
		 	
			if (arr[mid] == key){
				return -(mid + 1);
			}
			
			else if (arr[mid] > key){
				hi = mid - 1;
			}
			
			else{
				lo = mid + 1;
			}
		}
		
			
	
		
		return -(lo + 1);
	}
} // END PROJECT3