public class Fraction
{
	private int numer;
	private int denom;
	public int getNumer()
	{
		return numer;
	}
	public int getDenom()
	{
		return denom;
	}
	public String toString()
	{
		return numer + "/" + denom;
	}
	public void setNumer( int n )
	{
		numer = n;
	}
	public void setDenom( int d )
	{
		if (d!=0)
			denom=d;
		else
		{
			System.out.println("error");
		}
	}
	public Fraction(  )
	{
		this( 0, 1 );
	}
	public Fraction( int n )
	{
		this( n, 1 );

	}
	public Fraction( int n, int d )
	{
		int num = n, den = d;
		while (n != 0 && d != 0){
			int temp = d;
			d = n%d;
			n = temp;
		}
		int gcd = n+d;
		setNumer(num/gcd); 
		setDenom(den/gcd); 
	}
	public Fraction( Fraction other )
	{
		this( other.numer, other.denom );
	}
	private void reduce()
	{	
	}
	public Fraction add (Fraction other){
		return(new Fraction ((this.numer * other.denom)+(this.denom * other.numer), this.denom * other.denom));
	}
	public Fraction subtract (Fraction other){
		return(new Fraction ((this.numer * other.denom)-(this.denom * other.numer), this.denom * other.denom));
	}
	public Fraction multiply (Fraction other){
		return(new Fraction (this.numer * other.numer, this.denom * other.denom));
	}	
	public Fraction divide (Fraction other){
		return(new Fraction (this.numer * other.denom, this.denom * other.numer));
	}
	public Fraction reciprocal(){
		return(new Fraction (this.denom, this.numer));
	}
}