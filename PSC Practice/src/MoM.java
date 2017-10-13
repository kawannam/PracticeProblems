import java.util.*;

public class MoM {

	HashMap<String,HashSet<String>> cities;
	
	public MoM() {
		cities = new HashMap<String, HashSet<String>>();
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int flights = in.nextInt();
		in.nextLine();
		MoM c = new MoM();
		String city;
		String[] line;
		for( int i = 0; i < flights; i++ ) {
			line = in.nextLine().split(" ");
			if (!c.cities.containsKey(line[0])) {
				c.cities.put(line[0], new HashSet<String>());
				
			}
			c.cities.get(line[0]).add(line[1]);
		}
		String start;
		HashSet<String> vis;
		while(in.hasNext()) {
			start =in.nextLine();
			vis = new HashSet<String>();
			if (c.isLoop(start, vis)) {
				System.out.println(start + " safe");
			} else {
				System.out.println(start + " trapped");
			}
		}
	}
	
	public boolean isLoop(String cur, HashSet<String> vis) {
		if (cities.get(cur) == null) {
			return false;
		}
		if (cities.get(cur).isEmpty()) {
			return false;
		}
		if (vis.contains(cur)) {
			return true;
		}
		vis.add(cur);
		Iterator<String> a = cities.get(cur).iterator();
		String next;
		while (a.hasNext()) {
			HashSet<String> newVis = (HashSet<String>) vis.clone();
			next = a.next();
			if (isLoop(next, vis)) {
				return true;
			}
		}
		return false;
	}
}