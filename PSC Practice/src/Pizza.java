import java.util.Scanner;

public class Pizza {
	
	private static Scanner reader;
	int numOfComs;
	int[] watching;
	int[][] memo;
	int cost;
	int min;
	int best = 0;
	
	
	public static void main(String[] args) {
		Pizza p = new Pizza();
		p.read();
		System.out.println(p.best);
	}
	
	public void read(){
		reader = new Scanner(System.in);
		
		numOfComs = reader.nextInt();
		cost = reader.nextInt();
		//min = (cost)*(numOfComs)*(-1);
		min = 0;
		//memo = new int[numOfComs][numOfComs];
		//for(int i = 0; i < numOfComs; i++){
		//	for(int j = 0; j < numOfComs; j++){
		//		memo[i][j] = min;
		//	}
		//}
		watching = new int[numOfComs];
		for(int i = 0; i < numOfComs; i++){
			watching[i] = (reader.nextInt() - cost);
		}
		
		dp();
		
	}
	
	public void dp(){
		//int index = 0;
		int currentProfit = 0;
		for(int i = 0; i < numOfComs; i++){
			currentProfit += watching[i];
			if(currentProfit > best){
				best = currentProfit;
			}
			if (currentProfit < 0){
				//index = i + 1;
				currentProfit = 0;
			}
			
		}
	}
/*	
	public void dp(){
		int value;
		for(int index = (numOfComs-1); index > -1; index--){
			memo[index][0] = watching[index];
			if(memo[index][0] > best){
				best = memo[index][0];
			}
			if(index < (numOfComs - 1)){
				int i = 1;
				while((memo[index+1][i-1] != min) && (i < numOfComs)){
					value =  memo[index][0] + memo[index+1][i-1];
					memo[index][i] = value;
					if (value > best){
						best = value;
					}
					i++;
				}
			}
		}
	}
	*/
	

}
