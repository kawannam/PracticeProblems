import java.util.Scanner;

public class Pr {
	int paid;
	int numOfCoins;
	
	public Pr(int num1, int num2){
		paid = num1;
		numOfCoins = num2;
	}
	public Pr(){
		paid = 100000;
		numOfCoins = 10000;
	}
	
	public Pr( Pr p, int worth){
		paid = p.paid + worth;
		numOfCoins = p.numOfCoins +1;
	}

}


public class Coins {
	private static Scanner reader;

	int totCost;
	Pr[][] memo;
	int bestPrice;
	int bestCoin;
	int numberOfCoins;
	int[] coins;
	
	public static void main(String[] args) {
		reader = new Scanner(System.in);
		
		int testCases = reader.nextInt();
		reader.nextLine();
		for(int i =0; i < testCases; i++){
			int cost = Integer.parseInt(reader.nextLine());
			int coinNum = Integer.parseInt(reader.nextLine());
			int[] c = new int[coinNum];
			for(int coin: c){
				coin = Integer.parseInt(reader.nextLine());
			}
			
			
		}
	}
	
	private int wrapper(int coinNum, int[] c, int cost){
		totCost = cost;
		numberOfCoins = coinNum;
		coins = c;
		memo = new Pr[coinNum][(int) (Math.pow(2, coinNum))];
		return 0;
	}
	
	private int dp(int index){
		if(index == (numberOfCoins +1)){
			return 0;
		}
		if(index == 0){
			memo[index][0] = new Pr((totCost - coins[index]),1);
			memo[index][1] = new Pr(totCost, 0);
		}else{
			for()
			for(Pr p: memo[index-1]){
				if(p.numOfCoins == 10000){
					break;
				}
				
			}
		}
		return 0;
	}

}




