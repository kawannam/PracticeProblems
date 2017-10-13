import java.util.*;

public class Squawk {

	ArrayList<HashSet<Integer>> nodes;
	long[] squawks;
	
	public Squawk(int n) {
		nodes = new ArrayList<HashSet<Integer>>();
		for(int i = 0; i < n; i++) {
			nodes.add(new HashSet<Integer>());
		}
		squawks = new long[n];
	}
	
	public void addLink(int a, int b) {
		nodes.get(a).add(b);
		nodes.get(b).add(a);
	}
	
	public void tick() {
		long[] answers = new long[squawks.length];
		for(int i = 0; i < squawks.length; i++) {
			long count = 0;
			Iterator<Integer> it = nodes.get(i).iterator();
			while(it.hasNext()) {
				count += squawks[it.next()];
			}
			answers[i] = count;
		}
		squawks = answers;
	}
	
	public long getTotal() {
		long count = 0;
		for(int i = 0; i < squawks.length; i++) {
			Iterator<Integer> it = nodes.get(i).iterator();
			while(it.hasNext()) {
				int tem = it.next();
				count += squawks[tem];
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int s = in.nextInt();
		int t = in.nextInt();
		if (t == 0) {
			System.out.println("0");
			return;
		}
		
		Squawk sq = new Squawk(n);
		sq.squawks[s] = 1;
		for(int i = 0; i < m; i++ ) {
			sq.addLink(in.nextInt(), in.nextInt());
		}
		for(int i = 0; i < t-1; i++) {
			sq.tick();
		}
		System.out.println(sq.getTotal());
	}
}
