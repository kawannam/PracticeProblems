import java.util.HashMap;
import java.util.Scanner;
import java.lang.Math;

public class Classy {

	String[] names;
	Double[] classes;
	int index;
	
	public Classy(int size) {
		names = new String[size];
		classes = new Double[size];
		index = 0;
	}
	
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);		
		
		int testCases = reader.nextInt();
		reader.nextLine();
		
		for(int i =0; i < testCases; i++){
			int numberOfPeople = reader.nextInt();
			reader.nextLine();
			Classy c = new Classy(numberOfPeople);
			
			for( int j = 0; j < numberOfPeople; j++) {
			
				String input = reader.nextLine();
				String[] parts = input.split(" ");
				String name = parts[0].replaceAll(":","");
				String[] classList = parts[1].split("-");
				
				double pScore = 0;
				int numClasses = classList.length;
				for(int k = 0; k < numClasses; k++) {
					int x;
					if (classList[k].equals("upper")) {
						x = 3;
					} else if (classList[k].equals("middle")) {
						x = 2;
					} else {
						x = 1;
					}
					pScore += (x * Math.pow(10, (9 - numClasses + k + 1)));
				}
				for (int k = 0; k < (10 - numClasses); k++) {
					pScore += (2 * Math.pow(10, k));
				}
				c.names[c.index] = name;
				c.classes[c.index] = pScore;
				c.index++;
			}
			c.sort(numberOfPeople);
			for (int k = 0; k < numberOfPeople; k++) {
				System.out.println(c.names[k]);
			}
			System.out.println("==============================");
		}
		
	}
		
		public void sort(int numberOfPeople) {
			String tempName;
			Double tempClass;
			boolean sorted = false;
			while (!sorted) {
				sorted = true;
				for (int i = 0; i < numberOfPeople-1; i++) {
					if (classes[i] < classes[i+1]) {
						sorted = false;
						tempName = names[i];
						tempClass = classes[i];
						names[i] = names[i+1];
						classes[i] = classes[i+1];
						names[i+1] = tempName;
						classes[i+1] = tempClass;
						
					}
					if (classes[i].equals(classes[i+1])) {
						if( (0 < names[i].compareTo(names[i+1]))){
						sorted = false;
						tempName = names[i];
						tempClass = classes[i];
						names[i] = names[i+1];
						classes[i] = classes[i+1];
						names[i+1] = tempName;
						classes[i+1] = tempClass;
						}
					}
				}		
			}
		}
}
