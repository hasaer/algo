import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CoinTwo {

	static int N, K;
	static int[] coins;
	static int[][] dp;
	static int IMPOSSIBLE = 1000000;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		coins = new int[N];
		for (int i = 0; i < N; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		
		dp = new int[N + 1][K + 1];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[i].length; j++) {
				dp[i][j] = -1;	
			}
		}
		
		int result = calc(0, K);
		
		if (result == IMPOSSIBLE) {
			System.out.println(-1);
		} else {
			System.out.println(result);
		}
	}
	
	private static int calc(int n, int k) {
		if (n == N) return (k == 0 ? 0 : IMPOSSIBLE);
		if (dp[n][k] != -1) return dp[n][k];
		
		int result = calc(n + 1, k);
		if (k >= coins[n]) {
			int prev = calc(n, k - coins[n]) + 1; // 이전 루트에서 한 번 더 뺐을 때
			if (result > prev) {
				result = prev;
			}
		}
		
		dp[n][k] = result;
		return result;
	}
}
