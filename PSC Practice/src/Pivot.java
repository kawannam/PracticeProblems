import java.util.*;

public class Pivot {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++ ) {
			nums[i] = sc.nextInt();
		}
		
		Stack<Integer> rightMins = new Stack<Integer>();
		rightMins.push(nums[n-1]);
		int leftMax = Integer.MIN_VALUE;
		for (int i = n-2; i >= 0; i-- ) {
			if (nums[i] < rightMins.peek()) {
				rightMins.push(nums[i]);
			}
		}
		int answer = 0;
		for (int i = 0; i < n; i++) {
			if (nums[i] <= rightMins.peek() && nums[i] > leftMax) {
				answer++;
			}
			if (nums[i] == rightMins.peek()) {
				rightMins.pop();
			}
			if (leftMax < nums[i]) {
				leftMax = nums[i];
			}
		}
		System.out.println(answer);
	}

}
