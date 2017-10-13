import java.util.*;

public class Knapsack {

	static int VAL = 0;
	static int WEI = 1;
	
	double cap;
	int numO;
	double[][] objs;
	double maxVal = 0;
	String maxString = "";
	int maxCount = 0;
	
	int[][] things;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()) {
			Knapsack sack = new Knapsack();
			 sack.cap = in.nextDouble();
			 sack.numO = in.nextInt();
			 int value;
			 int weight;
			 sack.things = new int[sack.numO][(int)Math.floor(sack.cap)+ 1];
			for( int i = 0; i < sack.numO; i++ ) {
				value = in.nextInt();
				weight = (int)Math.floor(in.nextDouble());
			}

			sack.r(0, sack.cap, "", 0, 0);
			System.out.println(sack.maxCount);
			System.out.println(sack.maxString.substring(0, sack.maxString.length()-1));
		}

	}

	public void smrt() {
		for (int i = 0; i < numO; i++) {
			for (int j = 0; j < objs[i][WEI]; j++) {
				objs[i][]
			}
		}
	}
	public void r( double val, double wei, String chosen, int index, int count ) {
		if ( index >= numO ) {
			return;
		}
		if ( (wei - objs[index][WEI]) >= 0 ) {
			if ( ( val + objs[index][VAL] ) > maxVal) {
				maxVal = val + objs[index][VAL];
				maxString = (chosen + index + " ");
				maxCount = count+1;
			}
			r((val+objs[index][VAL]), (wei - objs[index][WEI]), (chosen + index + " "), (index+1), (count+1));
		}
		r(val, wei, chosen, (index+1), count ); 
	}
	
}
