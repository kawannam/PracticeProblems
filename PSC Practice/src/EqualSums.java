import java.util.*;
import java.lang.*;

public class EqualSums {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for (int tc = 0; tc < testCases; tc++) {
			System.out.println("Case #" + (tc+1) + ":");
			sc.nextInt();
			long[] numbers = new long[20];
			for (int i = 0; i < 20; i++) {
				numbers[i] = sc.nextLong();
			}
			EqualSums es = new EqualSums(numbers);
			es.solve();
		}
	}
	
	HashMap<Long, Long> seen;
	long[] set;
	
	public EqualSums(long[] numbers) {
		seen = new HashMap<Long, Long>();
		set = numbers;
	}

	public void solve() {
		for (int i = 0; i < 1048576; i++) { // 2 ^ 20 == 1048576
			long sum = getSum(i);
			if (seen.containsKey(sum)) {
				for (int j = 0; j < 20; j++) {
					if (((1 << j) & seen.get(sum)) != 0) System.out.print(set[j] + " ");
				}
				System.out.println();
				for (int j = 0; j < 20; j++) {
					if ((((1 << j) & (long)i) != 0)) System.out.print(set[j] + " ");
				}
				System.out.println();
				return;
				
			} else {
				seen.put(sum, (long)i);
			}
		}
		System.out.println("Impossible");
	}
	
	private long getSum(long bitmap) {
		long sum = 0;
		for (int i = 0; i < 20; i++) {
			if (((1 << i) & bitmap) != 0) sum += set[i];
		}
		return sum;
	}
}
