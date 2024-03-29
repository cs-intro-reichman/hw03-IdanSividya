/**
* Computes the periodical payment necessary to re-pay a given loan.
*/
public class LoanCalc {
	
	static double epsilon = 0.001;  // The computation tolerance (estimation error)
	static int iterationCounter;    // Monitors the efficiency of the calculation
	
    /** 
     * Gets the loan data and computes the periodical payment.
     * Expects to get three command-line arguments: sum of the loan (double),
     * interest rate (double, as a percentage), and number of payments (int).  
     */
	public static void main(String[] args) {		
		// Gets the loan data
		double loan = Double.parseDouble(args[0]);
		double rate = Double.parseDouble(args[1]);
		int n = Integer.parseInt(args[2]);
		System.out.println("Loan sum = " + loan + ", interest rate = " + rate + "%, periods = " + n);
		
		// Computes the periodical payment using brute force search
		System.out.print("Periodical payment, using brute force: ");
		System.out.printf("%.2f", bruteForceSolver(loan, rate, n, epsilon));
		System.out.println();
		System.out.println("number of iterations: " + iterationCounter);

		// Computes the periodical payment using bisection search
		System.out.print("Periodical payment, using bi-section search: ");
		System.out.printf("%.2f", bisectionSolver(loan, rate, n, epsilon));
		System.out.println();
		System.out.println("number of iterations: " + iterationCounter);
	}
	
	/**
	* Uses a sequential search method  ("brute force") to compute an approximation
	* of the periodical payment that will bring the ending balance of a loan close to 0.
	* Given: the sum of the loan, the periodical interest rate (as a percentage),
	* the number of periods (n), and epsilon, a tolerance level.
	*/
	// Side effect: modifies the class variable iterationCounter.
    public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {  
    	// define the payment to start from the loan sum/the number of periods, becase its the minimum payment (with 0% rate).
		
		double payment = loan / (double)n;
		iterationCounter = 0;
		// compute the approximation of the periodical payment that will bring the ending balance of a loan close to 0, and count the iterations.
		
		while (endBalance(loan,rate,n,payment)>=epsilon){
			payment  = payment + epsilon;
			iterationCounter ++;	
		}		
    	return payment;
  
    }
    
    /**
	* Uses bisection search to compute an approximation of the periodical payment 
	* that will bring the ending balance of a loan close to 0.
	* Given: the sum of theloan, the periodical interest rate (as a percentage),
	* the number of periods (n), and epsilon, a tolerance level.
	*/
	// Side effect: modifies the class variable iterationCounter.
   public static double bisectionSolver(double loan, double rate, int n, double epsilon) {
	// define the L to start from the loan sum/the number of periods, becase its the minimum payment and the H to be the loan (max).
	
    double L = loan / (double)n;
    double H = loan;
	// defined the payment to be the average of L and H.
	
    double payment = (L + H) / 2;
    iterationCounter = 0;
	// use bi-section search method to approximation of the periodical payment that will bring the ending balance of a loan close to 0
	
    while ((H - L) >= epsilon) {
        if (endBalance(loan, rate, n, payment) * endBalance(loan, rate, n, L) < 0) {
            H = payment;
        } else {
            L = payment;
        }

        payment = (L + H) / 2;
        iterationCounter++;
    }
    return payment;
}

	
	/**
	* Computes the ending balance of a loan, given the sum of the loan, the periodical
	* interest rate (as a percentage), the number of periods (n), and the periodical payment.
	*/
	private static double endBalance(double loan, double rate, int n, double payment) {
		// define the end to start with the loan sum. define the rate properly.
		double end = loan;
		rate = rate/100;
		// the for loop compute the ending balance according to the given parametens
		for (int i = 0; i < n; i++){
		end = (loan - payment) * (rate +1);
		loan = end;
		}
		// return the ending balance.
    	return end;	
		}
		
}
