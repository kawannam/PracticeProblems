import java.util.*;

public class Pet {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] score = new int[5];
		int winner = -1;
		int max = -1;
		for (int i = 0; i < 5; i++) {
			int total = 0;
			for (int j = 0; j < 4; j++) {
				total += in.nextInt();
			}
			if (total > max) {
				max = total;
				winner = i;
			}
		}
		System.out.println(winner+1 + " " + max);
	}

}
