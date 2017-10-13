import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.*;

public class CD {

	
	public static void main (String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String numbers;
		try {
			numbers = reader.readLine();
			String[] nm = numbers.split(" ");
			int n = Integer.parseInt(nm[0]);
			int m = Integer.parseInt(nm[1]);
			while(!((m==0) && (n==0))) {
	
					HashSet<String> jack = new HashSet<String>();
					HashSet<String> jill = new HashSet<String>();
					
					
					for (int j = 0; j < n; j++) {
						jack.add(reader.readLine());
					}
					for (int j = 0; j < m; j++) {
						jill.add(reader.readLine());
					}
					jack.retainAll(jill);
					System.out.println(jack.size());			
				
					numbers = reader.readLine();
					nm = numbers.split(" ");
					n = Integer.parseInt(nm[0]);
					m = Integer.parseInt(nm[1]);
				
			}	
		} catch (Exception e) {				
		}
	}
}
