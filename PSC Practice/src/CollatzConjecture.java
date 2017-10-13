import java.util.*;

public class CollatzConjecture {
			
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long a = (long)sc.nextInt();
		long b = (long)sc.nextInt();
		while(!(a == 0 && b == 0)) {
			HashMap<Long,Long> amap = new HashMap<Long, Long>();
			HashMap<Long,Long> bmap = new HashMap<Long, Long>();
			
			long origA = a;
			long origB = b;

			long astep = 0;
			long bstep = 0;
			while (true) {
				
				amap.put(a, astep);
				bmap.put(b, bstep);
				if (amap.containsKey(b)) {
					System.out.println(origA + " needs " + amap.get(b) + " steps, " + origB + " needs " + bstep + " steps, they meet at " + b);
					break;
				}
				if (bmap.containsKey(a)) {
					System.out.println(origA + " needs " + astep + " steps, " + origB + " needs " + bmap.get(a) + " steps, they meet at " + a);
					break;
				}
				
				if ( a != 1) {
					if (a % 2 == 0) {
						a = a/2;
					} else {
						a = (a*3) + 1;
					}
					astep++;
				}
				
				if (b != 1) {
					if (b % 2 == 0) {
						b = b/2;
					} else {
						b = (b*3) + 1;
					}
					bstep++;
				}
			}
			a = sc.nextInt();
			b = sc.nextInt();
		}

	}

}
