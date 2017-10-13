import java.util.*;

public class Kastenlauf {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for(int tc = 0; tc < testCases; tc++) {
			int beerStops = sc.nextInt();
			Spot home = new Spot(sc.nextInt(), sc.nextInt());
			ArrayList<Spot> beer = new ArrayList<Spot>();
			for(int bs = 0; bs < beerStops; bs++) {
				beer.add(new Spot(sc.nextInt(), sc.nextInt()));				
			}
			Spot fair = new Spot(sc.nextInt(),sc.nextInt());
			beer.add(fair);
			Kastenlauf k = new Kastenlauf(beer.toArray(new Spot[beer.size()]), fair);
			if ( k.findPath(home)){
				System.out.println("happy");
			} else {
				System.out.println("sad");
			}
		}
	}
	
	ArrayList<boolean[]> seen;
	Spot[] spots;
	boolean[] beer;
	Spot goal;
	
	public Kastenlauf(Spot[] _spots, Spot _goal){
		seen = new ArrayList<boolean[]>();
		spots = _spots;
		beer = new boolean[_spots.length];
		goal = _goal;
	}
	
	public boolean findPath(Spot current){
		if (current.x == goal.x && current.y == goal.y) {
			return true;
		}		
		boolean pathFound = false;
		for (int i = 0; i < beer.length; i++) {
			if (current.dist(spots[i]) <= 1000 && !beer[i]) {				
				beer[i] = true;
				pathFound = findPath(spots[i]);
				if (pathFound) {
					return true;
				}
			}
		}
		return false;
	}
}

class Spot {
	int x;
	int y;
	
	Spot(int _x, int _y){
		x = _x;
		y = _y;
	}
	
	public int dist(Spot a) {
		return Math.abs(a.x - x) + Math.abs(a.y - y);
	}
}
