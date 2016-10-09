import java.util.HashMap;
import java.util.Scanner;

public class Albert {

	HashMap<String, Integer> co;
	
	public Albert(){
		co = new HashMap<String, Integer>();
		co.put("Q",0);
		co.put("W",10);
		co.put("E",20);
		co.put("R",30);
		co.put("T",40);
		co.put("Y",50);
		co.put("U",60);
		co.put("I",70);
		co.put("O",80);
		co.put("P",90);
		
		co.put("A",1);
		co.put("S",11);
		co.put("D",21);
		co.put("F",31);
		co.put("G",41);
		co.put("H",51);
		co.put("J",61);
		co.put("K",71);
		co.put("L",81);
	
		co.put("Z",02);
		co.put("X",12);
		co.put("C",22);
		co.put("V",32);
		co.put("B",42);
		co.put("N",52);
		co.put("M",62);
	}

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);		
		Albert a = new Albert();
		int temp;
		
		int testCases = reader.nextInt();
		reader.nextLine();
		for(int i =0; i < testCases; i++){
			String input = reader.nextLine();
			int total = 0;
			char[] toType = input.toCharArray();
			String hand = "E";
			for(int j = 0; j <toType.length; j++){
				if(!((String.valueOf(toType[j])).equals(" "))){
					temp = a.steps(	hand, String.valueOf(toType[j]));
					hand = String.valueOf(toType[j]);
					total += (temp*2) + 1;
				}else{
					total += 5;
				}
			}
			
			System.out.println(total);
			reader.close();
			
		}
	}
	
	public int steps(String start, String end){
		int step = 0;
		int startX = co.get(start)/10;
		int startY = co.get(start)%10;
		
		int endX = co.get(end)/10;
		int endY = co.get(end)%10;
		
		return (Math.abs(startX - endX) + Math.abs(startY -endY)); 
	}

}
