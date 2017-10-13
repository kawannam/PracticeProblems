import java.util.*;

public class GlitchBot {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int x = in.nextInt();
		int y = in.nextInt();
		int n = in.nextInt();
		String[] moves = new String[n];
		in.nextLine();
		for (int i = 0; i < n; i++) {
			moves[i] = in.nextLine();
		}
		GlitchBot gb = new GlitchBot(x, y, moves);

	}

	public int face = 0;
	int x = 0;
	int y = 0;
	int goalX;
	int goalY;
	String[] moves;
	String[] instr = {"Forward", "Right", "Left"};
	public GlitchBot(int _x, int _y, String[] m) {
		goalX = _x;
		goalY = _y;
		moves = m;
		for (int i = 0; i < moves.length; i++) {
			for(int j = 0; j < 3; j++) {
				if(moves[i] == instr[j]) {
					// skip
					continue;
				}
				int xpre = x, ypre = y, fpre=face;
				if(solve(i, instr[j])){
					System.out.println(i+1 + " " + instr[j]);
					return;
				}
				x = xpre;
				y = ypre;
				face= fpre;
			}
			if (moves[i].equals("Right")) {
				right();
			} else if (moves[i].equals("Left")) {
				left();
			} else if (moves[i].equals("Forward")) {
				forward();
			}
		}
	}

	public void right() {
		face = (face + 1) % 4;
	}

	public void left() {
		face = (face - 1) % 4;
		if (face < 0) {
			face = face + 4;
		}
	}

	public void forward() {
		switch (face) {
		case 0:
			y++;
			break;
		case 1:
			x++;
			break;
		case 2: 
			y--;
			break;
		case 3:
			x--;
			break;
		}
	}


	public boolean solve(int i, String instr) {
		if (instr.equals("Right")) {
			right();
		} else if (instr.equals("Left")) {
			left();
		} else if (instr.equals("Forward")) {
			forward();
		}
		
		for(int m = i+1; m < moves.length; m++) {
			if (moves[m].equals("Right")) {
				right();
			} else if (moves[m].equals("Left")) {
				left();

			} else if (moves[m].equals("Forward")) {
				forward();
			}
		}
		if (goalX == x && goalY == y) {
			return true;
		}
		return false;
	}


}
