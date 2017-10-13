import java.util.Scanner;
import java.util.HashMap;

public class HayPoints {
	
	HashMap<String, Integer> cost;
	private static Scanner reader;
	
	public HayPoints() {
		cost = new HashMap<String, Integer>();
	}
	
	public static void main(String args[]) {
		reader = new Scanner(System.in);
		int m = reader.nextInt();
		int n = reader.nextInt();

		HayPoints h = new HayPoints();
		reader.nextLine();
		for (int i = 0; i < m; i++) {
			String a = reader.nextLine();
			String[] b = a.split(" ");
			h.cost.put(b[0], Integer.parseInt(b[1]));
		}
		String c;
		String[] d;
		Integer word;
		Integer total;
		for (int i = 0; i < n; i++) {
			total = 0;
			do {
				c = reader.nextLine();
				d = c.split(" ");
				for( String e : d) {
					word = h.cost.get(e);
					if ( word != null ) {
						total += word;
					}
				}
			} while (!d[0].equals("."));
			System.out.println(total);
		}
	}

}
