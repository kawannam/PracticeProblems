import java.util.*;

public class Timebomb {

	String zero = "***\n"
				+ "* *\n"
			    + "* *\n"
			    + "* *\n"
			    + "***\n";
	
	String one =  "  *\n"
				+ "  *\n"
			    + "  *\n"
			    + "  *\n"
			    + "  *\n";	
	
	String two =  "***\n"
				+ "  *\n"
			    + "***\n"
			    + "*  \n"
			    + "***\n";	
	
   String three = "***\n"
				+ "  *\n"
			    + "***\n"
			    + "  *\n"
			    + "***\n";
  
  String four =   "* *\n"
				+ "* *\n"
			    + "***\n"
			    + "  *\n"
			    + "  *\n";
  
  String five =   "***\n"
				+ "*  \n"
			    + "***\n"
			    + "  *\n"
			    + "***\n";
  
  String six =    "***\n"
				+ "*  \n"
			    + "***\n"
			    + "* *\n"
			    + "***\n";
  
  String seven =  "***\n"
				+ "  *\n"
			    + "  *\n"
			    + "  *\n"
			    + "  *\n";
  
  String eight =  "***\n"
				+ "* *\n"
			    + "***\n"
			    + "* *\n"
			    + "***\n";
  
  String nine =   "***\n"
				+ "* *\n"
			    + "***\n"
			    + "  *\n"
			    + "***\n";
  
  public Timebomb(String[] numbers) {
	  HashMap<String, Integer> convert = new HashMap<String, Integer>();
	  convert.put(zero, 0);
	  convert.put(one, 1);
	  convert.put(two, 2);
	  convert.put(three, 3);
	  convert.put(four, 4);
	  convert.put(five, 5);
	  convert.put(six, 6);
	  convert.put(seven, 7);
	  convert.put(eight, 8);
	  convert.put(nine, 9);
	  
	  int total = 0;
	  for (int i = 0; i < numbers.length; i++) {
		  if (convert.containsKey(numbers[i])) {
		  total += (convert.get(numbers[i]) * Math.pow(10, (numbers.length - i - 1)));
		  } else {
			  System.out.println("BOOM!!");
			  return;
		  }
	  }
	  if (total % 6 != 0) {
		  System.out.println("BOOM!!");
	  } else {
		  System.out.println("BEER!!");
	  }
  }

 
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		char[][] input = new char[5][];
		for (int r = 0; r < 5; r++) {
			input[r] = in.nextLine().toCharArray();
		}
		String[] number = new String[(input[0].length + 1)/4];
		for (int d = 0; d < Math.floor((input[0].length + 1)/4); d++) {
			number[d] = "";
			for(int r = 0; r < 5; r++) {
				number[d] += input[r][d*4];
				number[d] += input[r][d*4 + 1];
				if (d*4 + 1 != input[0].length) {
					number[d] += input[r][d*4 + 2];
				}
				number[d] += "\n";
			}			
		}
		Timebomb tb = new Timebomb(number);
		

	}

}
