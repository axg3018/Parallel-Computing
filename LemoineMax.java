import edu.rit.pj2.Vbl;

/**
 * Class LemoineMax provides a reduction variable for a LemoineSmp class.
 * It implements Vbl interface provided by the pj2 library.
 * It uses a custom reduction function to get maximum value.
 *
 * @author Arjun Gupta
 * @version 26-September-2018
 */
public class LemoineMax implements Vbl {

    int maxP, maxN;

    /**
     * Create a clone of this shared variable. Required interface function.
     *
     * @return return a new copy of current object
     */
    public Object clone() {
        try{
            LemoineMax vbl = (LemoineMax) super.clone();
            vbl.maxP = this.maxP;
            vbl.maxN = this.maxN;
            return vbl;

        } 
        catch (CloneNotSupportedException e) {
            throw new RuntimeException("LemoineMax clone error");
        }
    }

    /**
     * Reduces the Vbl object provided and the current object 
     * and stores the maximum. Required interface function.
     *
     * @param vbl Reduction interface object.
     */
    public void reduce(Vbl vbl) {
        LemoineMax newMax = (LemoineMax) vbl;

        //keep the one which is higher.
        if (this.maxP < newMax.maxP || (this.maxP == newMax.maxP && this.maxN < newMax.maxN)) {
            this.maxP = newMax.maxP;
            this.maxN = newMax.maxN;
        }
    }

    /**
     * Custom reduce function with two integer input to assign and reduce the
     * shared variable.
     *
     * @param compareP Lemoine Conjecture p.
     * @param number   The number on which Lemoine Conjecture is verified.
     */
    public void reduce(int compareP, int number) {

        //keep the one which is higher.
        if (this.maxP < compareP || (this.maxP == compareP && this.maxN < number)) {
            this.maxP = compareP;
            this.maxN = number;
        }
    }

    /**
     * Sets the shared variable to the given shared variable.
     * Required interface function
     *
     * @param vbl Reduction interface object.
     */
    public void set(Vbl vbl) {
        LemoineMax newMaxVbl = (LemoineMax) vbl;
        this.maxP = newMaxVbl.maxP;
        this.maxN = newMaxVbl.maxN;
    }
}