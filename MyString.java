public class MyString implements Comparable<MyString>
{
	private char[] letters;
	
	public MyString( String other )
	{	// MUST BE DEEP COPY: USE REAL STRING'S BUILT IN METHOD 
		// TO RETURN A DEEP COPY OF THE THE UNDERLYING CHAR ARRAY
		letters = new char[other.length()];
		for(int i=0;i<other.length();i++){
			letters[i] = other.charAt(i);
		}
	}
	public MyString( MyString other )
	{	
		letters = new char[other.letters.length];
		for(int i = 0; i < other.letters.length;i++)
			letters[i] = other.letters[i];
	}
	public int length()
	{
		return letters.length;
	}
	public char charAt(int index)
	{
		return letters[index]; 
	}
	public int compareTo(MyString other)
	{
		int n = 0;
		if(this.length() < other.length()){
     		return -1;
     	}
     	else if(this.length() == other.length()){
			while (n < this.length() && n < other.length()){
				if (this.letters[n] < other.letters[n])
					return -1;
				if(this.letters[n] > other.letters[n])
					return 1;
				n++;
			}
      		return 0;
      	}
    	else{ return 1;}
	}	
	public boolean equals(MyString other)
	{
		int n = 0;
		if(this.length() != other.length())
				return false;
		while (n < this.length() && n < other.length()){
			if(this.letters[n] != other.letters[n])
				return false;
			n++;
		}
		return true;
	}
	public int indexOf(int ch)	
	{
		for(int i=0;i<letters.length ;++i){
			if(ch==(letters[i]))
   			return i;
   		}
   		return -1;
   	}
	public int indexOf(MyString other)
	{
		char startLetter = other.charAt(0);
		for(int n = 0; n < (this.length() - other.length()+1); n++){
			for(int k = 0; k < other.length(); k++){
				if(this.letters[n+k] != other.letters[k]){
					break;
				}
				return n;
			}
		}
		return -1; 		
	}
	public String toString()
	{
		return new String(letters);
	}
} // END MYSTRING CLASS