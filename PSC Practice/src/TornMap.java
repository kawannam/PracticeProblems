import java.util.Scanner;
import java.util.LinkedList;
import java.util.HashMap;
import java.lang.StringBuilder;

public class TornMap {

	static HashMap<String, LinkedList<String>> map = new HashMap<>();
	
	private static Scanner reader;

	public static void main(String[] args) {
		reader = new Scanner(System.in);
		
		int pieces = reader.nextInt();
		reader.nextLine();
		
		
		for(int i =0; i < pieces; i++){
			String piece = reader.nextLine();
			String[] pieceArray = piece.split(" ");
			if(!map.containsKey(pieceArray[0])){
				map.put(piece,new LinkedList<String>());
			}
			for(int j =1; j < pieceArray.length; j++){
				map.get(pieceArray[0]).add(pieceArray[j]);
			}
		}
		
	}

	public String travelling(String here, String dest, String soFar){
		if (here.equals(dest)){
			return (soFar.concat(dest));
		}
		for (int i = 0; i < map.get(here).size(); i++){
			
		}
	}
}
