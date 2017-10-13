import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Internet {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		ArrayList<ArrayList<Integer>> con = new ArrayList<ArrayList<Integer>>();
		LinkedList<Integer> q  = new LinkedList<Integer>();
		boolean[] vis = new boolean[n];
		vis[0] = true;
		q.add(0);

		for(int i = 0; i < n; i++)
		{
			con.add(new ArrayList<Integer>());
		}
		for(int i = 0; i < m; i++)
		{
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
		    con.get(a).add(b);
		    con.get(b).add(a);
		}
		while(!q.isEmpty())
		{
			int a = q.removeFirst();
			for(int b : con.get(a))
			{
				if(!vis[b])
				{
					q.add(b);
					vis[b] = true;
				}
			}
		}
		LinkedList<Integer> no = new LinkedList<Integer>();
		for(int i = 0; i < n; i++)
		{
			if (!vis[i]) 
			{
				no.add(i);
			}
		}
		if(no.isEmpty())
		{
			System.out.println("Connected");
		}else{
			for(int b : no)
			{
				System.out.println(b+1);
			}
		}
	}

}
