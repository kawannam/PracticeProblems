import java.util.*;

public class MinimumSpanningTree {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		int m;
		while (true) {			
			n = sc.nextInt();
			m = sc.nextInt();
			if ((n == 0) && (m == 0)) {
				break;
			}
			ArrayList<LinkedList<Edge>> graph = new ArrayList<LinkedList<Edge>>();
			for (int i = 0; i < n; i++) {
				graph.add(new LinkedList<Edge>());
			}
			
			int u;
			int v;
			int w;
			
			for (int i = 0; i < m; i++) {
				u = sc.nextInt();
				v = sc.nextInt();
				w = sc.nextInt();
				
				Edge e = new Edge(u, v, w);
				graph.get(u).push(e);
				graph.get(v).push(e);
			}
			
		}
		
	}
	
	int[] nodes;
	int n;
	int m;
	
	public MinimumSpanningTree(int _n, int _m, ArrayList<Edge> e) {
		n = _n;
		m = _m;
		nodes = new int[n];
		for (int i = 0; i < n; i++) {
			nodes[i] = i;
		}
	}
	
	public Edge find(Edge x) {
		
	}
	
	public void union(Edge x) {
		int xr = find(x);
		int yr = find(y);
		nodes[xr] = yr;
	}
	
	
}

class Edge {
	
	int u;
	int v;
	int weight;
	
	public Edge(int _u, int _v, int _w) {
		u = _u;
		v = _v;
		weight = _w;
	}
	
	public boolean compare(Edge e) {
		return (weight < e.weight);
	}
}
