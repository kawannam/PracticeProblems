import java.util.*;

public class QuickEstimates {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.nextLine();
		for(int i = 0; i < n; i++) {
			char[] s = in.nextLine().toCharArray();
			System.out.println(s.length);
		}

	}

}
