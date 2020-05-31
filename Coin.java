/*
	Coin.java THIS IS THE ONLY FILE YOU HAND IN
	THERE IS NO MAIN METHOD IN THIS CLASS!
*/
import java.util.Random;
public class Coin
{
	private final int TAILS = 0;
	private final int HEADS = 1;
	private Random r;
	private int numHeads, numTails;
	
	public Coin (int seed){
		r = new Random(seed);
		setNumHeads(0);
		setNumTails(0);
	}//END COIN CONSTRUCTOR
	
	public String flip (){
		int side = r.nextInt(2);
		if (side == HEADS){
			setNumHeads(getNumHeads()+1);
			return "H";
		}
		else{
			setNumTails(getNumTails()+1);
			return "T";
		}
	}//END FILP
	
	public int getNumHeads(){
		return numHeads;
	}//END GET.NUMBER.HEADS
	
	public int getNumTails(){
		return numTails;
	}//END GET.NUMBER.TAILS
	
	public void reset(){
		setNumHeads(0);
		setNumTails(0);
	}//END RESET
	
	private void setNumHeads (int h){
		numHeads = h;
	}//END SETTER
	
	private void setNumTails (int t){
		numTails = t;
	}//END SETTER
} // END COIN CLASS