import java.util.*;

public class CoastLength {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		sc.nextLine();
		boolean[][] grid = new boolean[n+2][m+2];
		
		char[] current;
		
		for (int i = 0; i < n+2; i++) {
			grid[i][0] = false;
			grid[i][m+1] = false;
		}
		for (int j = 0; j < m+2; j++) {
			grid[0][j] = false;
			grid[n+1][j] = false;
		}
		
		
		for (int i = 0; i < n; i++) {
			current = sc.nextLine().toCharArray();			
			for (int j = 0; j < m; j++) {
				if (current[j] == '1') {
					grid[i+1][j+1] = true;
				} else {
					grid[i+1][j+1] = false;
				}
			}
		}
		
		CoastLength cl = new CoastLength(grid, n+2, m+2);
		cl.explore(0, 0);
		System.out.println(cl.answer);
	}
	
	boolean[][] grid;
	boolean[][] seen;
	int m;
	int n;
	int answer;
	
	public CoastLength(boolean[][] g, int _n, int _m) {
		m = _m;
		n = _n;
		answer = 0;
		grid = g;
		seen = new boolean[n][m];
		for (int i = 0; i < n; i++) {		
			for (int j = 0; j < m; j++) {
				seen[i][j] = false;
			}
		}
	}
	
	public void explore(int i, int j) {

		if (grid[i][j] == true) {
			answer += 1;
			return;
		}
		if (seen[i][j]) {
			return;
		}
		seen[i][j] = true;
		if (i + 1 < n) {
			explore(i+1, j);
		}
		if (j + 1 < m){
			explore(i, j+1);
		}
		if (i - 1 > 0){
			explore(i-1, j);
		}
		if (j - 1 > 0){
			explore(i, j-1);
		}
	}
}
