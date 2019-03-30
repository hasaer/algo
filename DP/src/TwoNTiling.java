import java.util.*;

public class TwoNTiling {

	static int[] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		dp = new int[N + 1];
		dp[0] = 1;
		dp[1] = 1;
		System.out.print(calc(N));
	}

	static int calc(int n) {
		if (n == 0) {
			return 1 % 10007;
		}

		if (n == 1) {
			return 1 % 10007;
		}

		if (dp[n] != 0) {
			return dp[n];
		}

		dp[n] = (calc(n - 1) + calc(n - 2)) % 10007;

		return dp[n];
	}

}
