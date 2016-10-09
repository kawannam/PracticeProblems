import java.util.Scanner;

public class Rings {
	
	char[][] tree;
	int[][] out;
	int n;
	int m;
	boolean isThree;
	
	
	public static void main( String[] args) {
		Scanner reader = new Scanner(System.in);
		int n = reader.nextInt();
		int m = reader.nextInt();
		char[][] tree = new char[n][m];
		char[][] out = new char[n][m];
		reader.nextLine();
		Rings ring = new Rings(n, m);		
		String line;
		for (int i = 0; i < n; i++ ) {
			line = reader.nextLine();
			ring.tree[i] = line.toCharArray();
		}
	}
	
	public Rings( int _n, int _m) {
		n= _n;
		m = _m;
		tree = new char[n][m];
		out = new int[n][m];
		isThree = false;
		r(0,0);
		p();
	}
	
	public int r(int _n, int _m) {
		if ((_n >= m) || (_m >= n) ) {
			return 0;
		}
		int a = r((_n+1), _m);
		int b = r(_n, (_m+1));
		int c = con
		if (con(tree[_n][_m]) == 0) {
			out[_n][_m] = 0;
			return 0;
		}
		out[_n][_m] = (min( a, b, c) + 1);
		if (out[_n][_m] > 100) {
			isThree = true;
		}
		return out[_n][_m];
		
	}
	
	public int min( int a, int b, int c ) {
		if (( a < b ) && ( a < c)) {
			return a;
		} else if ( b < c) {
			return b;
		} else {
			return c;
		}
	}
	
	public void p() {
		for(int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++ ) {
				System.out.print(out[i][j]);
				if(out[i][j] == 0){
					if(isThree) {
						System.out.print("...");
					} else {
						System.out.print("..");
					}
				} else {
					if(isThree) {
						if(out[n][m] < 10) {
							System.out.println(".." + out[n][m]);
						} else if (out[n][m] < 100) {
							System.out.println("." + out[n][m]);
						} else {
							System.out.println(out[n][m]);
						}
					}
				}
			}
			System.out.println();
		}
	}
	
	public int con( int x, int y) {
		if ( tree[x][y] == '.') {
			return 0;
		}
		return 1;
	}
}
