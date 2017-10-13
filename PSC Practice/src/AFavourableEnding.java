import java.util.*;

public class AFavourableEnding {
	public static void main(String[] arg) {
		Scanner in = new Scanner(System.in);
		int testCase = in.nextInt();
		
		for (int tc = 0; tc < testCase; tc++) {
			int sections = in.nextInt();
			 in.nextLine();
			HashSet<Integer> fav = new HashSet<Integer>();
			ArrayList<ArrayList<Integer>> book = new ArrayList<ArrayList<Integer>>();
			for (int s = 0; s < 401; s++) {
				book.add(new ArrayList<Integer>());
			}
			for (int s = 0; s < sections; s++) {
				String[] line = in.nextLine().split(" ");
				int p = Integer.parseInt(line[0]);
				if (line.length < 4) {
					if (line[1].equals("favourably")) {
						fav.add(p);
					}
				} else {
					book.get(Integer.parseInt(line[1])).add(p);
					book.get(Integer.parseInt(line[2])).add(p);
					book.get(Integer.parseInt(line[3])).add(p);
				}
			}
			AFavourableEnding fe = new AFavourableEnding(book, fav);
		}
	}
	
	ArrayList<ArrayList<Integer>> book;
	HashSet<Integer> fav;
	//int count;
	int[] visited;
	boolean[] vis;
	
	public AFavourableEnding(ArrayList<ArrayList<Integer>> trans, HashSet<Integer> favour ) {
		book = trans;
		fav = favour;
		int count = 0;
		visited = new int[book.size()];
		vis = new boolean[book.size()];
		gen();
		for (Integer i : fav) {
			//count += recur(i);
			count += visited[i];
		}
		System.out.println(count);

	}
	
	public void gen( ) {
		for (int cur = 0 ; cur < 401; cur++ )
		for (Integer i : book.get(cur)) {
				visited[i] += 1;
			}
	}
	
	public int recur(int cur) {
		if (cur == 1) {
			//count++;
			return 1;
		}
		if (vis[cur]) {
			return visited[cur];
		}
		//vis[cur] = true;
		int count = 0;
		for (Integer i : book.get(cur)) {
			if (!vis[i]) {
				count += recur(i);
			}
		}
		visited[cur] = count;
		return count;
	}
}
