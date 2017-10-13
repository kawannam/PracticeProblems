import java.util.*;

public class GameRank {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		char[] hist = in.nextLine().toCharArray();
		int star = 0;
		int rank = 25;
		int streak = 0;
		for( char h : hist) {
			if ( h == 'W') {
				star++;
				streak++;
				if (rank > 5) {
					if (streak >= 3) star++;
				}

				if (rank >= 21) {
					if (star > 2) {
						rank--;
						star = (star - 2);
					}
				} else if (rank >= 16) {
					if (star > 3) {
						rank--;
						star = (star - 3);
					}
				} else if (rank >= 11) {
					if (star > 4) {
						rank--;
						star = (star - 4);
					}
				} else if (rank >= 1) {
					if (star > 5) {
						rank--;
						if (rank == 0) {
							System.out.println("Legend");
							System.exit(0);
						}
						star = (star - 5);
					}
				} 
			}else {
				streak = 0;
				if (rank >= 21) {
					
				}else if (rank >= 20) {
					star--;
					if (star < 0) star = 0;
				} else if (rank >=16) {
					star--;
					if (star < 0) {
						rank++;
						star = 2;
					}
				} else if (rank >= 11) {
					star--;
					if (star < 0) {
						rank++;
						if( rank >= 16 )star = 2;
						else star = 3;
					}
				} else if (rank >= 1){
					star--;
					if (star < 0) {
						rank++;
						if( rank >= 11 )star = 3;
						else star = 4;
					}
				}
				
			}
		}
		System.out.println(rank);

	}

}
