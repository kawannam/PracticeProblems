import java.util.*;

public class PasswordHacking {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		in.nextLine();
		double E = 0;
		double[] chance = new double[num];
		for (int i = 0; i < num; i++) {
			String[] line = in.nextLine().split(" ");
			chance[i] = Double.valueOf(line[1]);
		}
		Arrays.sort(chance);
		for (int i = num; i > 0; i--) {
			E += (num - i + 1) * chance[i-1]; 
		}
		System.out.printf("%.4f\n",E);

	}

}
