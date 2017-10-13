import java.util.*;

public class ButtonBashing {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        for (int tc = 0; tc < testCases; tc++) {
            int n = sc.nextInt();
            int t = sc.nextInt();
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = sc.nextInt();
            }
            ButtonBashing bb = new ButtonBashing(t, n, b);
            bb.solve();
        }

    }
    
    int[] seen;
    int time;
    int n;
    int[] b;
    
    public ButtonBashing(int t, int _n, int[] _b) {
        seen = new int[3601]; //number of seconds in an hour
        time = t;
        n = _n;
        b = _b;
    }
    
    public void solve () {
    	
        Stack<Integer> seenThisRound = new Stack<Integer>();
        Stack<Integer> seenLastRound = new Stack<Integer>();
        int bp = 1;
        
        if (time == 0) {
            System.out.println("0 0");
            return;
        }
    	seen[0] = bp;
        for (int i = 0; i < n; i++){
            if (b[i] == time) {
                System.out.println("1 0");
                return;
            }
            if (b[i] > 0) {
            	seenLastRound.push(b[i]);
            	seen[b[i]] = bp;
            }
        }
        
        bp = 2;

        boolean makingProgress = true;
        while(makingProgress) {
        	makingProgress = false;
	        while(!seenLastRound.isEmpty()) {

	        	int sec = seenLastRound.pop();
	            for (int i = 0; i < n; i++){
	                int current = sec + b[i];
	                if (current > 3600) current = 3600;
	                if ((current > 0) && (seen[current] == 0)) {
	                	makingProgress = true;
	    	            seen[current] = bp;
	                    seenThisRound.push(current);
	                    if (current == time) {
	                        System.out.println(bp +" 0");
	                        return;
	                    }
	                }
	            }
	        }
	        seenLastRound = (Stack<Integer>)seenThisRound.clone();
        	seenThisRound = new Stack<Integer>();
	        bp++;
        }
        for (int i = time + 1; i <= 3600; i++) {
            if (seen[i] != 0) {
                System.out.println(seen[i] + " " + (i - time));
                return;
            }
        }
    }
}
