/* Lab3.java  InsertInOrder */

import java.util.*;
import java.io.*;

public class Lab3
{
	static final int INITIAL_CAPACITY = 5;

	public static void main( String args[] ) throws Exception
	{
		// ALWAYS TEST FOR REQUIRED INPUT FILE NAME ON THE COMMAND LINE
		if (args.length < 1 )
		{
			System.out.println("\nusage: C:\\> java Lab3 L3input.txt\n");
			System.exit(0);
		}
		// LOAD FILE INTO ARR USING INSERINORDER

		Scanner infile =  new Scanner( new File( args[0] ) );
		int[] arr = new int[INITIAL_CAPACITY];
		int count= 0;
		while (infile.hasNextInt())
		{
			if ( count == arr.length ) arr = upSize( arr );
			insertInOrder( arr, count, infile.nextInt() );
			++count; // WE JUST ADDED A VALUE - UP THE COUNT
		}
		infile.close();
		printArray( "SORTED ARRAY: ", arr, count );

	} // END MAIN
	// ################################################################

	// USE AS IS - DO NOT MODIFY
	static void printArray( String caption, int[] arr, int count  )
	{
		System.out.print( caption );
		for( int i=0 ; i<count ;++i )
			System.out.print(arr[i] + " " );
		System.out.println();
	}

	// YOU WRITE THIS METHOD - DO NOT MODIFY THIS FILE ANYWHERE ELSE
	// ################################################################
	static void insertInOrder( int[] arr, int count, int key   )
	{
	
		int i;
		for(i = (count - 1); i >= 0; i-=1)
		{
			if (key <= arr[i])
				arr[i+1] = arr[i];
			else
				break;
		}
		arr[i+1] = key;
		
	}
	static int[] upSize( int[] fullArr )
	{
		int[] newArr = new int[fullArr.length * 2];
		for(int i = 0;i < fullArr.length;i++)
			newArr[i] = fullArr[i];
		
		return newArr;
	}
} // END LAB3