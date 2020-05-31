import java.io.*;
import java.util.*;


/*
	FractionTester.java  A program that declares Fraction variables
*/
public class FractionTester
{
	public static void main( String args[] )
	{
		// use the word Fraction as if were a Java data type
		Fraction f1 = new Fraction();  // create an object of the fraction type

		f1.numerator = 22; // use dot operator to access numer or denom
		f1.denominator=7;
		System.out.println("f1=" + f1.numer + "/" + f1.denom); // outputs: "f1=22/7"
	} // END main
} // EOF