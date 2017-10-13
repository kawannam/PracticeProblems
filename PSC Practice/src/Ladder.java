import java.lang.Math;
import java.util.Scanner;
public class Ladder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int v = sc.nextInt();		
		System.out.println((int) Math.ceil(h/Math.sin(((Math.PI/180)*v))));
	}

}
