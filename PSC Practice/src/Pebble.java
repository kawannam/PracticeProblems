import java.util.Scanner;

public class Pebble {
	private static Scanner reader;

	public static void main(String[] args) {
		reader = new Scanner(System.in);
		
		int testCases = reader.nextInt();
		reader.nextLine();
		for(int i =0; i < testCases; i++){
			String boardString = reader.nextLine();
			char[] board = boardString.toCharArray();
			
			}
			String soundsInput = reader.nextLine();
			
			String[] soundsArray = soundsInput.split(" ");
		}
	
	
	public int eleminate(){
		int min = 23;
		
		return min;
	}
	
	public void move(){
		for(int i = 0; i < 23; i++){
			if( board[i] == "o"){
				int j;
				while((board[j] == "o") && j < 23){
					j++;
				}
				if(j != i){
				move left?;
					recurse left on updated board;
				move right?
					recurse right on update board;
			}
		}
		
	}
	}
	public boolean check(char dir, int i, int j){
			if(dir =='r'){
				if (j < (23 -1)){
					return true;
				}
				return false;
			}
			if(i > 0){
				return true;
			}
			return false;
	}
	
	public void update(char[] board, char dir, int i){
		
}
}
