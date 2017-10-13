import java.util.*;
public class Logo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for(int tc = 0; tc < testCases; tc++) {
			 int moves = sc.nextInt();
			 double x = 0;
			 double y = 0;
			 double angle = 0;
			 sc.nextLine();
			 for (int i = 0; i < moves; i++) {
				 String[] command = sc.nextLine().split(" ");
					double amount = Integer.parseInt(command[1]);
					
					if (command[0].equals("fd")) {
						x += Math.sin(angle) * amount;
						y += Math.cos(angle) * amount;
					} else if (command[0].equals("bk")) {
						x -= Math.sin(angle) * amount;
						y -= Math.cos(angle) * amount;
					} else if (command[0].equals("lt")) {
						angle += Math.toRadians(amount);
					} else {
						angle -= Math.toRadians(amount);
					}
			 }
			 double distance = Math.sqrt( (x * x) + (y *y));
			 System.out.println(Math.round(distance));
		}

	}	
}

