/**
 * Class LemoineSmp extends class Task from pj2 Library and uses 
 * a for loop to verify Lemoine Conjecture for a given range 
 * and print it for highest value of p.
 *
 * Usage: <TT>java pj2 LemoineSeq <I>lb</I> <I>ub</I></TT>
 * <BR><TT><I>lb</I></TT> = lower bound (int)
 * <BR><TT><I>ub</I></TT> = upper bound (int)
 * 
 * @author  Arjun Gupta
 * @version 26-Sep-2018
 */


public class LemoineSeq extends edu.rit.pj2.Task{

    /**
     * The main program takes a lower bound and upper bound as command line
     * arguments verifies the conjecture for every odd integer in the range
     * and print it for highest value of p
     *
     * @param command line arguments - lower bound and upper bound
     *
     */

	public void main(final String[] args) {
		
        if (args.length < 2) usage();
        try{
            Integer.parseInt(args[0]);   
            Integer.parseInt(args[1]);
        }
        catch(Exception e){
            usage();
        }   
        int lb = Integer.parseInt(args[0]);
        int ub = Integer.parseInt(args[1]);
        if(lb > ub || lb % 2 == 0 || ub % 2 == 0 || lb < 7) usage();

		
        LemoineMax max = new LemoineMax();
        for(int n = lb; n <= ub; n = n+2){
			LemoineMin lm = new LemoineMin(n);
            int p = lm.minP();

            max.reduce(p, n);

		}
        int maxp = max.maxP;
        int maxn = max.maxN;
        int maxq = (maxn - maxp) >> 1;
		System.out.println(maxn + " = " + maxp + " + 2*" + maxq);	
	}


	/**
	 * Print a usage message and exit.
	 */
	private static void usage(){
		
		System.err.println ("Usage: java pj2 LemoineSeq <lb> <ub>");
		System.err.println ("<lb> = lower bound(Odd integer > 5)");
		System.err.println ("<ub> = upper bound(Odd integer >= lb)");
		terminate(1);
	}
}	