import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class FenceOrthogonality {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int vNum = sc.nextInt();
			ArrayList<Veg> gard = new ArrayList<Veg>();
			for (int i = 0; i < vNum; i++)
			{
				gard.add(new Veg(sc.nextInt(), sc.nextInt()));
			}
			Collections.sort(gard, new Comparator<Veg>() {
				@Override
				public int compare(Veg arg0, Veg arg1) {
					if (arg0.y < arg1.y)
					{
						return -1;
					}
					else if (arg0.y > arg1.y)
					{
						return 1;
					}
					return 0;
				}
				
			});
						
			ArrayList<Veg> bor = new ArrayList<Veg>();
			bor.add(gard.remove(0));
			Veg first = bor.get(0);
			Veg base = new Veg(first.x+1, first.y);
			Collections.sort(gard, new Comparator<Veg>() {
				@Override
				public int compare(Veg arg0, Veg arg1) {
					double d0 = arg0.calcAngle(base, first);
					double d1 = arg1.calcAngle(base, first);
					if (d0 < d1) {
						return -1;
					}
					else if (d0 > d1)
					{
						return 1;
					} else {
						double dist0 = first.calcDist(arg0);
						double dist1 = first.calcDist(arg1);
						
						if ((d0 <= 0) && (dist0 < dist1)){
							return -1;
						} else if((d0 <= 0) && (dist0 > dist1)) {
							return 1;
						} else if ((d0 > 0) && (dist0 < dist1)) {
							return 1;
						} else {
							return -1;
						}
					}
				}
				
			});
			
			//Collections.sort(gard);
			bor.add(gard.remove(0));
			int j = 1;
			for(Veg v : gard){
				if (bor.get(j).calcAngle(bor.get(j-1), v) < 90){
					bor.add(v);
				} else {
					bor.remove(j);
					bor.add(v);
				}
			}
			//ArrayList
			for (Veg b : bor){
				
			}
		
		}
	}

}
class Veg implements Comparable<Veg> {
	int x;
	int y;
	
	Veg(int px, int py) {
		x = px;
		y = py;
	}

	@Override
	public int compareTo(Veg o) {
		if (y < o.y)
		{
			return -1;
		}
		else if (y > o.y)
		{
			return 1;
		}
		return 0;
	}
	
	public double calcAngle(Veg from, Veg to)
	{
		int ux = from.x - x;
		int vx = to.x - x;
		int uy = from.y - y;
		int vy = to.y - y;
		int d = (ux * vx) + (uy * vy);
		return d;
	}
	
	public double calcDist(Veg o)
	{
		return Math.sqrt(((x - o.x)*(x - o.x)) + ((y - o.y)*(y - o.y)));
	}
}