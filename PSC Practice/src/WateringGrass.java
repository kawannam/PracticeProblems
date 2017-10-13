import java.util.*;

public class WateringGrass {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while (sc.hasNext()) {
			int n = sc.nextInt();
			double l = (double)sc.nextInt();
			double w = (double)sc.nextInt();
	
			WateringGrass wg = new WateringGrass();
			double h = w/2;
			for (int i = 0; i < n; i++ ) {
				double x = (double)sc.nextInt();
				double r = (double)sc.nextInt();
				if (r > h) {
					double length = Math.sqrt((r*r) - (h * h));
					wg.spk.add(new Pair(x-length, x + length));
				}
			}
			double current = 0;
			Pair next;
			int count = 0;
			while (current < l) {
				next = wg.find(current);
				if ( next == null) {
					count = -1;
					break;
				} else {
				count++;
				current = next.right;
				}
			}
			System.out.println(count);
		}
		
	}
	
	ArrayList<Pair> spk;
	
	WateringGrass () {
		spk = new ArrayList<Pair>();
	}
	
	public Pair find(double current) {
		double right = current;
		Pair answer = null; 
		for (Pair s : spk) {
			if ((s.left <= current) && (s.right >= right)){
				answer = s;
				right = s.right;
			}
		}
		spk.remove(answer);
		return answer;
	}

}

class Pair {
	double left;
	double right;
	public Pair(double l, double r) {
		right = r;
		left = l;
	}
}