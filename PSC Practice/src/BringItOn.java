import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class BringItOn {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> words = new ArrayList<String>();
		int testCases = sc.nextInt();
		sc.nextLine();
		ArrayList<node> connections = new ArrayList<node>();
		for( int i = 0; i < testCases; i++)	{
			boolean found = false;
			char[] c = sc.nextLine().toCharArray();
			for(node n : connections) {
				if (n.value == c[0]) {
					n.trav(Arrays.copyOfRange(c, 1, c.length));
					found = true;
				} 
			}
			if(!found) {
				node blah = new node(c[0]);
				connections.add(blah);
				blah.trav(Arrays.copyOfRange(c, 1, c.length));
			}
		}		
	}
}

class node {
	ArrayList<node> connections;
	char value;
	int below;
	node(char _value){
		connections = new ArrayList<node>();
		value = _value;
		below = 0;
	}
	node(){
		
	}
	public void trav(char[] c) {
		boolean found = false;
		if (c.length == 0) {
			System.out.println(below);
			
		} else {
			for(node n : connections) {
				if (n.value == c[0]) {
					n.trav(Arrays.copyOfRange(c, 1, c.length));
					found = true;
				} 
			}
			if(!found) {
				node blah = new node(c[0]);
				connections.add(blah);
				blah.trav(Arrays.copyOfRange(c, 1, c.length));
			}
		}
		below++;
	}
}
