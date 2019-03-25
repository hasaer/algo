import java.util.*;

public class DPNumberOne {

	static int[] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		dp = new int[N + 1];
		System.out.print(calc(N));
	}
	
	static int calc(int idx) {
		if (idx <= 0) {
			dp[0] = 0;
			return 0;
		} else if (idx == 1) {
			dp[1] = 0;
			return 0;
		} else {
			int min = calc(idx - 1) + 1;
			int temp = min;
			
			if (idx % 3 == 0) {
				temp = dp[idx / 3] + 1;
				if (temp < min) {
					min = temp;
				}
			}
			
			if (idx % 2 == 0) {
				temp = dp[idx / 2] + 1;
				if (temp < min) {
					min = temp;
				}
			}
			
			dp[idx] = min;
			
			return min;
		}
	}

}
