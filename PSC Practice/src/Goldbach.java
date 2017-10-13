import java.util.*;

public class Goldbach {

	public boolean[] isPrime;
	
	public Goldbach() {
		
	}
	
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		int evens[] = new int[testCases];
		int max = 0;
		for (int i = 0; i < testCases; i++) {
			evens[i] = in.nextInt();
			if(evens[i] > max) {
				max = evens[i];
			}
		}
		Goldbach gold = new Goldbach();
		gold.genPrime(max + 1);
		for(int i = 0; i < testCases; i++) {
			gold.findThem(evens[i]);
		}
	}
	
	public void genPrime(int num) {
		isPrime = new boolean[num+1];
		for (int i = 2; i < num; i++) {
			isPrime[i] = true;
		}
		for(int i = 2; i*i <= num; i++) {
			if(isPrime[i]) {
				for (int j = i; i*j<num; j++) {
					isPrime[i*j] = false;
				}
			}
		}
	}
	
	public void findThem(int num) {
		LinkedList<String> list = new LinkedList<String>();
		int j = 1;
		int k = num;
		int lastPrime = 0;
		int lastJ = num;
		int count = 0;
		while ((j < k) && (lastJ != j)) {
			lastJ = j;
			j = nextPrime(j, num);
			while ((j + k > num) && (2 != k)){
				lastPrime = k;
				k = prevPrime(k, num);
				
			}
			if (((k+j) == num) && ( j <= k)) {
				count++;
				list.addLast(j + "+" + k);
			} else {
				k = lastPrime;
			}
			
		}
		System.out.println( num + " has " + count + " representation(s)");
		ListIterator<String> stuff = list.listIterator();
		while(stuff.hasNext()) {
			System.out.println(stuff.next());
		}
		System.out.println("");
	}
	
	public int nextPrime(int j, int num) {
		j++;
		while(!isPrime[j]) {
			j++;
		}
		return j;
	}
	public int prevPrime(int k, int num) {
		k--;
		while(!isPrime[k] && (k >= 2)) {
			k--;
		}
		return k;
	}
	
	
}
