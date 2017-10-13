import java.util.*;

public class KindsOfPeople {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int rows = in.nextInt();
		int columns = in.nextInt();
		String blah = in.nextLine();
		boolean[][] map = new boolean[rows][columns];
		int[] group = new int[rows*columns];
		for (int r = 0; r < rows; r++) {
			char[] temp = in.nextLine().toCharArray();
			for(int c = 0; c < columns; c++) {
				int num = Character.getNumericValue(temp[c]);
				if(num == 0) {
					map[r][c] = false;
				} else {
					map[r][c] = true;
				}
				group[(r*columns) + c] = (r*columns) + c;
			}
		}
		int queries = in.nextInt();
		KindsOfPeople kp = new KindsOfPeople(map, group, columns, rows);
		for (int n = 0; n < queries; n++) {
			int cR = in.nextInt() - 1;
			int cC = in.nextInt() - 1;
			int gR = in.nextInt() - 1;
			int gC = in.nextInt() - 1;
			if (kp.getParent(kp.flatten(cR, cC )) == kp.getParent(kp.flatten(gR, gC))) {
				if(map[cR][cC]) {
					System.out.println("decimal");
				} else {
					System.out.println("binary");
				}
			} else {
				System.out.println("neither");
			}
		}

	}
	
	public void unionFind() {
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				if ((i < rows-1) && (map[i][j] == map[i+1][j])) {
					group[flatten(i,j)] = group[flatten(i+1,j)] = Math.min(group[flatten(i, j)], group[flatten(i+1, j)]);
				}
				if ((i > 0) && (map[i][j] == map[i-1][j])) {
					group[flatten(i,j)] = group[flatten(i-1,j)] = Math.min(group[flatten(i, j)], group[flatten(i-1, j)]);
				}
				if ((j < columns - 1) && (map[i][j] == map[i][j+1])) {
					group[flatten(i,j)] = group[flatten(i,j+1)] = Math.min(group[flatten(i, j)], group[flatten(i, j+1)]);
				}
				if ((j > 0) && (map[i][j] == map[i][j-1])) {
					group[flatten(i,j)] = group[flatten(i,j-1)] = Math.min(group[flatten(i, j)], group[flatten(i, j-1)]);
				}
			}
		}
	}
	
	public int getParent(int index) {
		if (index == group[index]) {
			return index;
		}
		return getParent(group[index]);
	}
	
	public int flatten(int r, int c) {
		return (r * columns) + c;
	}
	
	boolean[][] map;
	int columns;
	int rows;
	int[] group;
	
	public KindsOfPeople(boolean[][] m, int[] g, int c, int r) {
		map = m;
		columns = c;
		rows =r;
		group = g;
		unionFind();
	}

}
