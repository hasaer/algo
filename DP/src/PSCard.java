import java.util.*;

public class PSCard {

	static int[] dp, cards;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		dp = new int[N + 1];
		cards = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			cards[i] = sc.nextInt();
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= i; j++) {
				if (dp[i] < cards[j] + dp[i - j]) {
					dp[i] = cards[j] + dp[i - j]; // 클 경우 갱신
				}
			}
		}
		
		System.out.println(dp[N]);
	}
	
}
