import java.util.*;

public class Election {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int tc = 0; tc < testCases; tc++) {
			int N = in.nextInt();
			int V1 = in.nextInt();
			int V2 = in.nextInt();
			int W = in.nextInt();
			int votesNeeded = (int)Math.floor((double)N/(double)2) - V1 + 1;
			int votesLeft = N - V1 - V2;
			
			double answer = (1 - probabilityOfLoss(votesNeeded, votesLeft)) * 100;
			if (answer > ( W + 0.000001 ) || votesNeeded <= 0) {
				System.out.println("GET A CRATE OF CHAMPAGNE FROM THE BASEMENT!");
			} else if (votesNeeded > votesLeft) {
				System.out.println("RECOUNT!");
			} else  {
				System.out.println("PATIENCE, EVERYONE!");
			}
		}
	}
	
	static public double probabilityOfLoss(int votesAway, int votesLeft) {
		double p = 0;
		for (int i = 0; i < votesAway; i++) {
			p += prob(i,votesLeft);
		}
		return p;
	}
	
    static public double prob(int i, int outOf) {
    	return Math.pow(0.5, i) * Math.pow(0.5, outOf - i) * nChooseK(outOf, i);    	
    }
    
    static public double nChooseK(int n, int k) {
    	double ans = (fact(n)/(fact(k) * fact(n - k)));
    	return ans;
    }
    
    static public double fact(int n) {
    	double fact = 1;
    	for (int i = n; i > 0; i-- ) {
    		fact *= i;
    	}
    	return fact;
    }

}
