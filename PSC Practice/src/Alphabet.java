import java.util.HashMap;
import java.util.Scanner;
import java.lang.Character;
import java.lang.StringBuilder;

public class Alphabet {

	HashMap<Character, String> co;
	
	public Alphabet(){
		co = new HashMap<Character, String>();
		co.put('A',"@");
		co.put('B',"8");
		co.put('C',"(");
		co.put('D',"|)");
		co.put('E',"3");
		co.put('F',"#");
		co.put('G',"6");
		co.put('H',"[-]");
		co.put('I',"|");
		co.put('J',"_|");		
		co.put('K',"|<");
		co.put('L',"1");
		co.put('M',"[]\\/[]");
		co.put('N',"[]\\[]");
		co.put('O',"0");
		co.put('P',"|D");
		co.put('Q',"(,)");
		co.put('R',"|Z");
		co.put('S',"$");	
		co.put('T',"\'][\'");
		co.put('U',"|_|");
		co.put('V',"\\/");
		co.put('W',"\\/\\/");
		co.put('X',"}{");
		co.put('Y',"`/");
		co.put('Z',"2");
	}
	
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);		
		Alphabet a = new Alphabet();
		StringBuilder output = new StringBuilder();
		String input = reader.nextLine();
		input = input.toUpperCase();
		for( char c : input.toCharArray() ){
			if (a.co.containsKey(c)) {
				output.append(a.co.get(c));
			} else {
				output.append(c);
			}
		}		
		System.out.println(output.toString());
		reader.close();
	}
}
