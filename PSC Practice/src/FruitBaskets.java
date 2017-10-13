import java.util.*;

public class FruitBaskets {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numFruit = sc.nextInt();
		int[] fruit = new int[numFruit];
		long sum = 0;
		int current;
		for (int i = 0; i < numFruit; i++ ) {
			current = sc.nextInt();
			sum += current;
			fruit[i] = current;
		}
		
		long complete = sum << (numFruit - 1);
		
		for (int f = 0; f < numFruit; f++) {
			if ( fruit[f] < 200) {
				complete -= fruit[f];
				
				for (int g = (f + 1); g < numFruit; g++) {
					if ((fruit[g] + fruit[f]) < 200) {
						complete -= (fruit[g] + fruit[f]);
						
						for (int k = (g + 1); k < numFruit; k++){
							if ( (fruit[f] + fruit[g] + fruit[k]) < 200) {
								complete -= (fruit[f] + fruit[g] + fruit[k]);
							}
						}
					}
				}
			}
		}
		
		System.out.println((long)complete);
	}

}
