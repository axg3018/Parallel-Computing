import edu.rit.pj2.Loop;
import java.util.*;

/**
 * Class LemoineSmp extends class Task from pj2 Library and uses 
 * a parallel loop to verify Lemoine Conjecture for a given range 
 * and print it for highest value of p.
 *
 * Usage: <TT>java pj2 <I>cores=K</I> LemoineSmp <I>lb</I> <I>ub</I></TT>
 * <BR><TT><I>lb</I></TT> = lower bound
 * <BR><TT><I>ub</I></TT> = upper bound
 * <BR><TT><I>K</I></TT> = No. of cores
 *
 * @author  Arjun Gupta
 * @version 26-Sep-2018
 */
public class LemoineSmp extends edu.rit.pj2.Task{


    LemoineMax max;

    /**
     * The main program takes a lower bound and upper bound as command line
     * arguments verifies the conjecture for every odd integer in the range
     * and print it for highest value of p
     *
     * @param command line arguments - lower bound and upper bound
     *
     */
	public void main(final String[] args) throws Exception{

        if (args.length < 2) usage();
        try{
            Integer.parseInt(args[0]);
            Integer.parseInt(args[1]);
        }
        catch(Exception e){
            usage();
        }   
        final int lb = Integer.parseInt(args[0]);
        final int ub = Integer.parseInt(args[1]);

        if(lb > ub || lb % 2 == 0 || ub % 2 == 0 || lb < 7) usage();
   	
        int totalOdd = ((ub - lb) >> 1) + 1 ;
        max = new LemoineMax();
        
      	parallelFor (0, totalOdd-1) .exec (new Loop(){

            LemoineMax thrMax;

            public void start() {
                    thrMax = threadLocal(max);
                }

                public void run(int i) {
                    int n = ((2*i) + lb);
                    LemoineMin lm = new LemoineMin(n);
                    int p = lm.minP();

                    thrMax.reduce(p, n);                     
                
                }

        });
        
        int maxp = max.maxP;
        int maxn = max.maxN;
        int maxq = (maxn - maxp) >> 1;
        System.out.println(maxn + " = " + maxp + " + 2*" + maxq);
    }

    /**
     * Print a usage message and exit.
     */
    private static void usage(){
        
        System.err.println ("Usage: java pj2 cores=<K> LemoineSmp <lb> <ub>");
        System.err.println ("<K> = number of cores (optional)");
        System.err.println ("<lb> = lower bound(Odd integer > 5)");
        System.err.println ("<ub> = upper bound(Odd integer >= lb)");
        terminate(1);
    }

}	