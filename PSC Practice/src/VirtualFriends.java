import java.util.*;

public class VirtualFriends {


	HashMap<String, Integer> connections = new HashMap<String, Integer>();
	int[] parent;
	int[] rank;
	int[] size;
	
	public VirtualFriends() {
		
	}
	
	public void solve(int[][] pairs) {
		parent = new int[connections.size()];
		rank = new int[connections.size()];
		size = new int[connections.size()];
		for (int p = 0; p < parent.length; p++){
			parent[p] = p;
			rank[p] = 1;
			size[p] = 1;
		}
		
		for (int i = 0; i < pairs.length; i++) {
			union(pairs[i][0], pairs[i][1]);
			System.out.println(size[find(pairs[i][0])]);
		}
	}
	
	public int find(int x) {
		int rep = parent[x];
		if (x == rep){
			return x;
		}
		parent[x] = find(parent[x]);
		return parent[x];
	}
	
	public void union(int x, int y) {
		int repX = find(x);
		int repY = find(y);
		if (repX != repY) {
			if (rank[repX] <= rank[repY]) {
				parent[repX] = repY;
				rank[repY]++;
				size[repY] += size[repX];
			} else {
				parent[repY] = repX;
				rank[repX]++;
				size[repX] += size[repY];
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();
		for (int t = 0; t < tests; t++)
		{
			VirtualFriends vf = new VirtualFriends();
			int friends = sc.nextInt();
			int[][] pairs = new int[friends][2];
			int index = 0;
			sc.nextLine();
			for (int f = 0; f < friends; f++){
				String[] names = sc.nextLine().split(" ");
				if (!vf.connections.containsKey(names[0])) {
					vf.connections.put(names[0], index);
					index++;
				}
				if (!vf.connections.containsKey(names[1])) {
					vf.connections.put(names[1], index);
					index++;
				}
				pairs[f][0] = vf.connections.get(names[0]);
				pairs[f][1] = vf.connections.get(names[1]);				
			}
			vf.solve(pairs);
		}

	}

}
