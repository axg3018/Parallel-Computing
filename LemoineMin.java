/**
 * Class LemoineMin calculates the minimum p 
 * for Lemoine Conjecture for a given value of n
 *
 * @author  Arjun Gupta
 * @version 1-Oct-2018
 */



public class LemoineMin{
	
	int p, q;
	
	/**
	 * Constructor to calculate minimum value
	 * of p for Lemoine Conjecture by taking
	 * n as an argument
	 *
	 * @param n - an odd integer within given range
	 *
	 */
	LemoineMin(int n){

		Prime.Iterator itr = new Prime.Iterator();
		do{
        	p = itr.next();  
        	q = (n - p) >> 1;
        } while(!Prime.isPrime(q));


	}

	/**
	 * Returns minimum value of p
	 *
	 * @return p
	 */
	public int minP(){

		return p;

	}

	
}