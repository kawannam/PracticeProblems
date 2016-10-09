import java.util.HashMap;
import java.util.Scanner;
import java.lang.Math;

public class A {
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);		
		
		int testCases = reader.nextInt();
		reader.nextLine();
		
		for(int i =0; i < testCases; i++){
			int numberOfPeople = reader.nextInt();
			
			HashMap<Double, String> people = new HashMap<Double, String>();
			reader.nextLine();
			
			for( int j = 0; j < numberOfPeople; j++) {
			
				String input = reader.nextLine();
				String[] parts = input.split(" ");
				String name = parts[0].substring(0, parts[0].length());
				String[] classList = parts[1].split("-");
				double pScore = 0;
				for(int k = 0; k < classList.length; k++) {
					int x;
					if (classList[k].equals("upper")) {
						x = 3;
					} else if (classList[k].equals("middle")) {
						x = 2;
					} else {
						x = 1;
					}
					pScore += Math.pow(x, (i));
					
				}
				people.put(pScore, name);
			}
			
			Double[] scores = (people.keySet()).toArray(new Double[numberOfPeople]);
			for (int k = 0; k < numberOfPeople; k++) {
				
			}
			
			
			System.out.println();
			reader.close();
			
		}
	}
	
	static Double[] mSort(Double[] items) {
		Double[] answer = new Double[items.length];
		for (int k = 0; k < items.length; k++) {
			double max = 0;
			for (int i = 0; i < items.length; k++) {
				if ( items[i] > max ) {
					max = items[i];
					items[i] = (double) 0;
				}
			}
			answer[k] = max;
		}
		return answer;
	}
	
	
}