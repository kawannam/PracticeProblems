import java.util.*;

public class NiceNumber {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tests = in.nextInt();
		in.nextLine();
		for(int tc = 0; tc < tests; tc++) {
			char[] line = in.nextLine().toCharArray();
			List<Integer> answer = new LinkedList<Integer>();
			for ( char c : line) {
				answer.add(Character.getNumericValue(c));
			}
			NiceNumber.makeEven2(answer);
			//NiceNumber.makeEven(answer, 4);
			//NiceNumber.makeEven(answer, 8);
			
			for(Integer i : answer) {
				System.out.print(i);
			}
			System.out.println();
			
		}
	}
	
	public static void makeEven2(List<Integer> answer) {
		for(int i = answer.size() - 1; i >= 0 ; i--) {
			if (answer.get(i) == 2) {
				int count = 0;
				while( i >= 0 && answer.get(i) == 2) {
					count++;
					i--;
				}
				if (count % 2 != 0) {
					answer.add(Math.max(i+1, 0), 2);
				}
			}
		}		
	}
	
	public static void makeEven4(List<Integer> answer) {
		for(int i = answer.size() - 1; i >= 0 ; i--) {
			if ((answer.get(i) == 4)|| ((answer.get(i) == 2) && (i - 1 >= 0) && (answer.get(i-1))) {
				int count = 0;
				while( i >= 0 && answer.get(i) == 4) {
					count++;
					i--;
				}
				if (count % 2 != 0) {
					answer.add(Math.max(i+1, 0), 4);
				}
			}
		}
	}
}
