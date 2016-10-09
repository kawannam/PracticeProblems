import java.util.HashSet;
import java.util.Scanner;

public class BitByBit {

	private static Scanner reader;

	public static void main(String[] args) {
		reader = new Scanner(System.in);
		
		String input;
		do{
			
			int testCases = reader.nextInt();
		
			for(int i = 0; i < testCases; i++){
				
				input = reader.nextLine();
				String[] a = input.split(" ");
				if(a[0].equals("SET")){
					set()
				}
			
			
			
			
			HashSet<String> sounds = new HashSet<>();
			
			
				
				String[] inputArray = input.split(" ");
				sounds.add(inputArray[2]);
			
			}while(testCases !=0));
			
			for(String sound: soundsArray){
				if(!sounds.contains(sound)){
					System.out.print( sound + " ");
				}
			}		

			
			System.out.println();

			
		}
		
		private void clear(int i, int[] bit){
			bit[i] = 0;
		}
		private void set(int i, int[] bit){
			bit[i] = 1;
		}
		private void or(int i, int j, int[] bit){
			bit[i] = (i + j)%1;
		}
		private void and(int i, int j, int[] bit){
			
			if( bit[i] == 1 && bit[j] == 1){
				bit[i] = 1;
			}else{
				bit[i] = 0;
			}
		}
	
}
