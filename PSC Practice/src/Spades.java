import java.util.Scanner;

public class Spades {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);		
		
		int testCases = reader.nextInt();
		reader.nextLine();
		for(int i =0; i < testCases; i++){
			int a = reader.nextInt();
			int b = reader.nextInt();
			float right = 0;
			int left = 0;
			for(int n =2; n < 1000000; n++){
				float n2 = n;
				right = (((n2*n2) - n2)*a)/(b * -1);
				left = quad(1,-1,right);
				if( left != -1){
					System.out.println(left + " " + n);
					break;
				}
				System.out.println("Checked: " + n);
			}
			
		}
	}

		public static int quad(float a, float b, float c){
			
			double plus =  (((b*-1) + Math.sqrt(((b*b)-(4*a*c))))/(2*a));
			double minus = (((b*-1) - Math.sqrt(((b*b)-(4*a*c))))/(2*a));
			
			double off = plus%1;
			if((plus > 0) && ( off > -0.001)&&(off < 0.001)){
			//if((plus > 0) && (plus%1 == 0)){
				return (int)(plus/1);
			}
			off =minus%1 - 1;
			if((minus > 0) && ( off > -0.001)&&(off < 0.001)){
				int z = 5;
				return (int)(minus/1);
			}
			return -1;
			
		}
}
