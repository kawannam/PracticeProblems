import java.util.Scanner;

public class Virus {
	private static Scanner reader;

	public static void main(String[] args) {
		reader = new Scanner(System.in);
		

			char[] healthy = reader.nextLine().toCharArray();
			char[] infected = reader.nextLine().toCharArray();
			
			
			int min = Math.min(healthy.length, infected.length);
			int firstDiff = 0;
			int secondDiff = 0;
			
			for(int i = 0; i < min; i++){
				if( healthy[i] != infected[i]){
					firstDiff = i;
					break;
				}
				firstDiff = i + 1;
			}
			for(int i = 1; i <= min; i++){
				if( healthy[(healthy.length - i)] != infected[(infected.length -i)]){
					secondDiff = i - 1;
					break;
				}
				//secondDiff = 0;
			}
			
			System.out.println(infected.length - firstDiff - secondDiff );
			
		}

}
