import java.util.*;
public class GreetingCard {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		HashSet<pair> card = new  HashSet<pair>(); 
		for (int i = 0; i < n; i++) {
			pair p = new pair(in.nextLong(),in.nextLong());
			card.add(p);
		}		
		long count = 0;
		for (pair p : card) {
			if (card.contains(new pair(p.x + 2018, p.y))) {
				count++;
			} 
			if (card.contains(new pair(p.x - 2018, p.y))) {
				count++;
			}
			if (card.contains(new pair(p.x, p.y - 2018))) {
				count++;
			} 
			if (card.contains(new pair(p.x, p.y + 2018))) {
				count++;
			}
			if (card.contains(new pair(p.x + 1118, p.y + 1680))) {
				count++;
			}
			if (card.contains(new pair(p.x + 1118, p.y - 1680))) {
				count++;
			}
			if (card.contains(new pair(p.x - 1118, p.y + 1680))) {
				count++;
			}
			if (card.contains(new pair(p.x - 1118, p.y - 1680))) {
				count++;
			}
			
			if (card.contains(new pair(p.x + 1680, p.y + 1118))) {
				count++;
			}
			if (card.contains(new pair(p.x + 1680, p.y - 1118))) {
				count++;
			}
			if (card.contains(new pair(p.x - 1680, p.y + 1118))) {
				count++;
			}
			if (card.contains(new pair(p.x - 1680, p.y - 1118))) {
				count++;
			}
		}
		System.out.println(count/2);
	}
}

class pair {
	long x;
	long y;
	
	public pair(long _x, long _y) {
		x = _x;
		y = _y;
	}
	
	@Override
	public boolean equals(Object p) {
		pair pa = (pair)p;
		if (x == pa.x && y == pa.y) {
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return (int)(x*5 + y*13);
	}
}
