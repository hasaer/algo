import java.util.*;

public class Add123 {

	static int[] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int N = sc.nextInt();
			dp = new int[N + 1];
			dp[0] = 1;
			dp[1] = 1;
			System.out.println(calc(N));
		}
	}
	
	static int calc(int n) {
		if (dp[n] != 0)
			return dp[n];
		
		int temp = 0;
		
		if (n >= 1) {
			temp += calc(n - 1);
		}
		
		if (n >= 2) {
			temp += calc(n - 2);
		}
		
		if (n >= 3) {
			temp += calc(n - 3);
		}
		
		dp[n] = temp;
		return dp[n];
	}
}
