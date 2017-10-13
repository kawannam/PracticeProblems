import java.util.Scanner;
import java.util.HashMap;
import java.util.HashSet;

public class DeduplicatingFiles {
	
	HashMap<String, Bucket> files;
	
	public DeduplicatingFiles() {
		files = new HashMap<String, Bucket>();
	}
	
	public static void main(String args[]) {
		Scanner reader = new Scanner(System.in);
		int numFiles = reader.nextInt();
		while (numFiles != 0) {
			DeduplicatingFiles df = new DeduplicatingFiles();
			
			int newFiles = 0;
			int copyFiles = 0;
			int col = 0;
			reader.nextLine();
			for (int j = 0; j < numFiles; j++) {
				String file = reader.nextLine();
				String hash = hashMe(file);
				if(df.files.containsKey(hash)) {
					int temp =df.files.get(hash).addFile(file);
						col += temp;
						//this is wrong
						newFiles++;
					}
				} else {
					newFiles++;
					df.files.put(hash, new Bucket(file));
				}
				System.out.println("Col " + col);
			}
			System.out.println(newFiles + " " + copyFiles + " " + col);
		}
		reader.close();
	}
	
	public static String hashMe(String file) {
		char[] ca = file.toCharArray();
		char answer = 0;
		for( char f: ca) {
			answer = (char)(answer ^ f);
		}
		return answer + "";
	}
	//kendra: make object with buck of files, and count of collisions of hash

}

class Bucket {
	HashMap<String, Integer> files;
	int count;
	
	public Bucket(String file) {
		files = new HashMap<String, Integer>();
		files.put(file, 1);
	}
	
	public int addFile( String file ) {
		 int col = 0;
		for( Integer i: files.values()) {
			col += i;
		}
		if (files.containsKey(file)) {
			return col - files.get(file);
		}
		files.put(file, 1);
		return col;
	}	
}
