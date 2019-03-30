import java.util.*;

public class DPNumberOne {

	static int[] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		dp = new int[N + 1];
		Arrays.fill(dp, -1);
		System.out.print(calc(N));
	}
	
	static int calc(int n) {
		if (n == 1) {
			return 0;
		} else {
			if (dp[n] != -1) {
				return dp[n];
			}
			
			int min = calc(n - 1) + 1;
			int temp = min;
			
			if (n % 3 == 0) {
				temp = dp[n / 3] + 1;
				if (temp < min) {
					min = temp;
				}
			}
			
			if (n % 2 == 0) {
				temp = dp[n / 2] + 1;
				if (temp < min) {
					min = temp;
				}
			}
			
			dp[n] = min;
			
			return min;
		}
	}

}
