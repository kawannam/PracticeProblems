import java.util.Scanner;

public class Jabuke {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Point la = new Point(sc.nextInt(), sc.nextInt());
		Point lb = new Point(sc.nextInt(), sc.nextInt());
		Point lc = new Point(sc.nextInt(), sc.nextInt());
		
		Tri land = new Tri(la, lb, lc);
				
		int pNum = sc.nextInt();
		int total = 0;
		for (int i = 0; i < pNum; i++) {
			Point p = new Point(sc.nextInt(), sc.nextInt());
			Tri ta = new Tri(p, la, lb);
			Tri tb = new Tri(p, la, lc);
			Tri tc = new Tri(p, lb, lc);
			if ((ta.area + tb.area + tc.area) == land.area) {
				total++;
			}
		}
		System.out.println(land.area);
		System.out.println(total);

	}

}

class Point {
	int x;
	int y;
	public Point(int px, int py)
	{
		x = px;
		y = py;
	}
}

class Tri {
	Point a;
	Point b;
	Point c;
	
	double area;
	
	Tri (Point pa, Point pb, Point pc)
	{
		a = pa;
		b = pb;
		c = pc;
		calcArea();
	}
	
	public void calcArea()	{
		int i = (b.y - c.y)*a.x;
		int j = (c.y - a.y)*b.x;
		int k = (a.y - b.y)*c.x;
		
		int l = Math.abs(i + j + k);
		area =  l/2.0;
	}
	
	
	
}
