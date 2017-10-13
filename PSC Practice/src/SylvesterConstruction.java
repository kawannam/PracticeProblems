import java.util.*;

public class SylvesterConstruction {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();
		for (int t = 0; t < tests; t++){
			SylvesterConstruction s = new SylvesterConstruction(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
		    s.solve();
			System.out.println("BLAH");
		}

	}
	int n;
	int x;
	int y;
	int w;
	int h;
	boolean[][] mat;
	
	public SylvesterConstruction(int size, int _x, int _y, int height, int width) {
		n = size;
		x = _x;
		y = _y;
		h = height;
		w = width;
		
		mat = new boolean[w][h];
		for (int i = 0; i < w; i++) {
			for (int j = 0; j < h; j++) {
				mat[i][j] = true;
			}
		}
	}
	
	public boolean xor(boolean value) {
		if (value) {
			return false;
		}
		return true;
	}
	
	public void flip(int xx, int yy, int hh, int ww) {
		for (int i = xx; i < (xx + ww); i++) {
			for (int j = yy; j < (yy + hh); j++) {
				mat[i][j] = xor(mat[i][j]);
			}
		}
	}

	public void solve() {
		for (int i = x; i < (x + w); i++) {
			for (int j = y; j < (y + h); j++) {
				if (solveSquare(i+1,j+1, n)) {
					System.out.print("1 ");
				} else {
					System.out.print("-1 ");
				}
			}
			System.out.println();
		}
	}
	
	public boolean solveSquare(int i, int j, int size) {
		if ( size == 1) {
			return true;
		}
		boolean c = solveSquare(i, j, size/2);
		if ((size/2 < i) && (size/2 < j) && (j <= size) && (i <= size)) {
			c = xor(c);
		}
		return c;
	}

}
