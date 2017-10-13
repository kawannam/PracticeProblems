import java.util.*;

public class SevenWonders {

	static char TABLET = 'T';
	static char COMPASS = 'C';
	static char GEAR = 'G';
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		char[] line = in.nextLine().toCharArray();
		int[] score = new int[3];
		for (char c : line) {
			if (c == TABLET) {
				score[0]++;
			}
			else if ( c == COMPASS) {
				score[1]++;
			}
			else if (c == GEAR) {
				score[2]++;
			}
		}
		int bonus = Math.min(score[0], score[1]);
		bonus = Math.min(score[2], bonus);
		
		System.out.println((score[0]*score[0]) + (score[1]*score[1]) + (score[2]*score[2]) + (7 * bonus));

	}

}
