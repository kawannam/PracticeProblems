import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
public class MinSpanTree {

	int[] nodes;
	int n;
	int m;
	ArrayList<Edge> edges;
	ArrayList<Edge> answer;
	
	public MinSpanTree(int _n, int _m, ArrayList<Edge> e) {
		n = _n;
		m = _m;
		nodes = new int[n];
		for (int i = 0; i < n; i++) {
			nodes[i] = i;
		}
		edges = e;
		Collections.sort(edges);
		answer = new ArrayList<Edge>();
		Solve();
		if(IsPossible()) {
			System.out.println(Cost());
			Answer();
			
		} else {
			System.out.println("Impossible");
		}
	}
	
	int Find(int x) {
		if(x == nodes[x]) {
			return x;
		} else {
			int a = Find(nodes[x]);
			nodes[x] = a;
			return a;
		}
	}
	
	void Union(int x, int y) {
		int xr = Find(x);
		int yr = Find(y);
		nodes[xr] = yr;
	}
	
	void Solve() {
		for (Edge e : edges) {
			if(Find(e.u) != Find(e.v)) {
				answer.add(e);
				Union(e.v, e.u);
			}
		}
	}
	long Cost() {
		long cost = 0;
		for (Edge e : answer) {
			cost += e.w;
		}
		return cost;
	}
	
	boolean IsPossible() {
		boolean a = true;
		int b = Find(0);
		for(int i = 1; i < n; i++) {
			if( Find(i) != b ) {
				a = false;
				break;
			}
		}
		return a;
	}
	
	void Answer() {
		Collections.sort(answer, new Comparator<Edge>(){

			@Override
			public int compare(Edge arg0, Edge arg1) {
				if(arg0.v < arg1.v) {
					return -1;
				} else if (arg0.v > arg1.v) {
					return 1;
				} else {
					if(arg0.u < arg1.u) {
						return -1;
					} else if (arg0.u > arg1.u) {
						return 1;
					} else {
						return 0;
					}
				}
			}
			
		});
		for(Edge e: answer) {
			System.out.println(e.v + " " + e.u );
		}
	}
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n;
		int m;
		n = in.nextInt();
		m = in.nextInt();
		while (!((n==0)&&(m==0))){
			ArrayList<Edge> edges = new ArrayList<Edge>();
			for (int i = 0; i < m; i++) {
				edges.add(new Edge(in.nextInt(), in.nextInt(), in.nextInt()));
			}
			MinSpanTree t = new MinSpanTree(n, m, edges);
			n = in.nextInt();
			m = in.nextInt();
		}
		in.close();
	}
}

class Edge implements Comparable<Edge> {
	int v;
	int u;
	int w;
	
	public Edge(int _v, int _u, int _w) {
		if(_v < _u){
			v = _v;
			u = _u;
		} else {
			v = _u;
			u = _v;
		}

		w = _w;
	}

	@Override
	public int compareTo(Edge arg0) {
		Edge other = (Edge)arg0;
		if( w == other.w) {
			return 0;
		} else if ( w < other.w) {
			return -1;
		} else {
			return 1;
		}
	}
}

