import java.util.*;

public class OddGnome {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int tc = 0; tc < testCases; tc++) {
			int gnomes = in.nextInt();
			int[] stuff = new int[gnomes];
			for (int g = 0; g < gnomes; g++) {
				stuff[g] = in.nextInt();
			}
			solve(gnomes, stuff);

			}
		}
	public static void solve(int gnomes, int[] stuff) {
		for (int i = 0; i < gnomes - 1; i++) {
			if(stuff[i]> stuff[i+1]) {
			 if(i+2 < gnomes && stuff[i] < stuff[i+2]) {
				 System.out.println(i+1+1);
				 return;
			 }else {
				 System.out.println(i+1);
				 return;
			 }
			}
		
		}
	}
}
