import java.util.*;
public class pth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		long x = in.nextLong();
		while( x != 0) {
			long answer = 1;
			long p = 1;
			long subTotal;
			boolean isNeg = false;
			if(x < 0) {
				x *= -1;
				isNeg = true;
			}
			long max = (int)Math.sqrt(x);
			for(long b = 2; b <= max; b++) {
				subTotal = b;
				p = 1;
				while(subTotal < x) {
					subTotal *= b;
					p++;
					if (subTotal == x) {
						if ((!isNeg) || ((isNeg) && ((p%2) != 0))){
							answer = p;
							break;
						}
					}
				}
				if (answer != 1) {
					break;
				}
			}
			System.out.println(answer);
			x = in.nextLong(); 
		}
	}
}
