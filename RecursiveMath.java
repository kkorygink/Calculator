package cs1302.calc;

/* Implement the Math interface using recursion here. For each method, replace
 * the throw statement with your implementation.
 */

/**
 * Implements the Math interface using pure tail recursive methods
 */
public class RecursiveMath implements Math {

    public int add(int lhs, int rhs) {
     
	if(rhs == 0) return lhs;
	if(lhs == 0) return rhs;
	return add(dec(lhs), inc(rhs));
    } // add

    public int sub(int lhs, int rhs) {

	if(rhs == 0) return lhs;
	if (rhs > lhs) return 0;
	return sub(dec(lhs), dec(rhs));
    } // sub

    public int mul(int lhs, int rhs) {

	return mul_acc(lhs, lhs, rhs);
    } // mul

    /**
     * uses an accumulator variable to facilitate pure 
     * tail recursion for the mul method.
     **/
    private int mul_acc(int sum, int lhs, int rhs){

	if(rhs == 0 || lhs == 0) return 0;
	if(rhs == 1) return sum;
	return mul_acc(add(sum, lhs), lhs, dec(rhs));
    }//mul_acc

    public int div(int lhs, int rhs) {

	if(rhs == 0) throw new ArithmeticException();
	return div_acc(0, lhs, rhs);
    } // div

    /**
     * uses an accumulator variable to facilitate pure 
     * tail recursion for the div method.
     **/
    private int div_acc(int counter, int lhs, int rhs){

	if(lhs < rhs) return counter;
       	return div_acc(inc(counter), sub(lhs, rhs), rhs);
    }//div_acc

    public int fac(int n) {

	return fac_acc(1, n);
    } // fac

    /**
     * uses an accumulator variable to facilitate pure 
     * tail recursion for the fac method.
     **/
    private int fac_acc(int acc, int n){

	if(n == 0) return acc;
	return fac_acc(mul(n, acc), dec(n)); 
    }//fac_acc

    public int pow(int lhs, int rhs) {

	return pow_acc(1, lhs, rhs);
    } // pow

    /**
     * uses an accumulator variable to facilitate pure 
     * tail recursion for the pow method.
     **/
    private int pow_acc(int acc, int lhs, int rhs){

	if (rhs == 0) return acc;
	return pow_acc(mul(acc, lhs), lhs, dec(rhs));
    }//pow_acc

} // RecursiveMath
