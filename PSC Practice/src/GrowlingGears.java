import java.util.*;

public class GrowlingGears {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();
		for (int t = 0; t < tests; t++ ) {
			int numberOfGears = sc.nextInt();
			double max = Double.MIN_VALUE;
			int maxGear = 0;
			for (int n = 0; n < numberOfGears; n++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				int c = sc.nextInt();
				double maxX = (double)b/(2 * (double)a);
				double gearMax = (maxX * maxX * a * -1) + (b * maxX) + c; 
				if (gearMax > max) {
					maxGear = n;
					max = gearMax;
				}
			}
			System.out.println(maxGear + 1);
		}

	}

}
