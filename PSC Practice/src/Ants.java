import java.util.Scanner;

public class Ants {
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);		
		
		int testCases = reader.nextInt();
		reader.nextLine();
		for(int i =0; i < testCases; i++){
			int numAnts = reader.nextInt();
			int[] ants = new int[numAnts];
			for(int j = 0; j < numAnts; j++){
				ants[j] = reader.nextInt();
			}
			
			String input = reader.nextLine();
		}
	}
}
