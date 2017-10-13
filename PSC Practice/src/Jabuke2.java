import java.util.*;

public class Jabuke2 {

	boolean[][] field;
	int R;
	int C;
	
	public Jabuke2(boolean[][] f, int ROW, int COLUMN) {
		field = f;
		R = ROW;
		C = COLUMN;
	}
	
	public long findTree(int x, int y) {
		LinkedList<Point> toSearch = new LinkedList<Point>();
		boolean[][] visited = new boolean[R][C];
		toSearch.add(new Point(x,y));
		visited[x][y] = true;
		int answer = Integer.MAX_VALUE;
		while(!toSearch.isEmpty()) {
			Point p = toSearch.pop();
			if (field[p.x][p.y]) {
				 int dx = x - p.x;
				 int dy = y - p.y;
				 int sqDist = Math.round((dx * dx) + (dy *dy));
				 if (sqDist < answer) {
					 answer = sqDist;
				 }
			}
			if (p.x+1 < R && !visited[p.x+1][p.y]) {
				toSearch.add(new Point(p.x+1, p.y));
				visited[p.x+1][p.y] = true;
			}			
			if (p.x-1 >= 0 && !visited[p.x-1][p.y]) {
				toSearch.add(new Point(p.x-1, p.y));
				visited[p.x-1][p.y] = true;
			}	
			if (p.y+1 < C && !visited[p.x][p.y+1]) {
				toSearch.add(new Point(p.x, p.y+1));
				visited[p.x][p.y+1] = true;
			}
			if (p.y-1 >= 0 && !visited[p.x][p.y-1]) {
				toSearch.add(new Point(p.x, p.y-1));
				visited[p.x][p.y-1] = true;
			}
			
			
		}
		return -1;
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int ROWS = sc.nextInt();
		int COLUMNS = sc.nextInt();
		sc.nextLine();
		boolean[][] field = new boolean[ROWS][COLUMNS];
		for (int i = 0; i < ROWS; i++) {
			char[] line = sc.nextLine().toCharArray();
			for (int j = 0; j < COLUMNS; j++ ) {
				if (line[j] == 'x') {
					field[i][j] = true;
				}
				else {
					field[i][j] = false;
				}
			}
		}
		Jabuke2 j = new Jabuke2(field, ROWS, COLUMNS);
		int years = sc.nextInt();
		for (int year = 0; year < years; year++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			System.out.println(j.findTree(x-1, y-1));
			j.field[x-1][y-1] = true;
			
		}
	}
}

class Point {
	int x;
	int y;
	
	Point(int _x, int _y) {
		x = _x;
		y = _y;
	}
}
