import java.util.*;
import java.lang.*;

public class QuickBrownFox {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		in.nextLine();
		for(int tc = 0; tc < testCases; tc++) {
			boolean[] alph = new boolean[26];
			char[] line = in.nextLine().toCharArray();
			for (char c : line) {
				c = Character.toLowerCase(c);
				if (c >= 'a' && c <= 'z') {
					alph[c - 'a'] = true;
				}
			}
			String missing = "";
			for (int i = 0; i < 26; i++) {
				if (!alph[i]) {
					missing += (char)(i + 'a');
				}
			}
			if (missing.equals("")) {
				System.out.println("pangram");
			} else {
				System.out.println("missing " + missing);
			}
		}

	}

}
