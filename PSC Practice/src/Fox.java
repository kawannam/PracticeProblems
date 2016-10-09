import java.util.Scanner;
import java.util.HashSet;

public class Fox {

	private static Scanner reader;

	public static void main(String[] args) {
		reader = new Scanner(System.in);
		
		int testCases = reader.nextInt();
		reader.nextLine();
		for(int i =0; i < testCases; i++){
			String soundsInput = reader.nextLine();
			String[] soundsArray = soundsInput.split(" ");
			
			
			
			
			HashSet<String> sounds = new HashSet<>();
			String input;
			do{
				input = reader.nextLine();
				String[] inputArray = input.split(" ");
				sounds.add(inputArray[2]);
			
			}while(!input.equals("what does the fox say?"));
			
			for(String sound: soundsArray){
				if(!sounds.contains(sound)){
					System.out.print( sound + " ");
				}
			}		

			
			System.out.println();

			
		}
	}

}
