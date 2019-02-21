import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sticker {

	static int[][] values, dp;
	
	static int T = 0, N = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			
			values = new int[2][N];
			for (int i = 0; i < 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());			
				for (int j = 0; j < N; j++) {
					values[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			dp = new int[N + 1][3];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < 3; j++) {
					dp[i][j] = 0;
				}
			}
			
			for (int i = 0; i < N; i++) {
				dp[i+1][0] = Math.max(dp[i+1][0], Math.max(dp[i][0], Math.max(dp[i][1], dp[i][2])));
	            dp[i+1][1] = Math.max(dp[i+1][1], Math.max(dp[i][0], dp[i][2]) + values[0][i]);
	            dp[i+1][2] = Math.max(dp[i+1][2], Math.max(dp[i][0], dp[i][1]) + values[1][i]);
			}
			
			System.out.println(Math.max(dp[N][0], Math.max(dp[N][1], dp[N][2])));
			
//			System.out.println();
//			System.out.println(calcSticker(0, 0));
			
//			for (int i = 0; i < dp.length; i++) {
//				for (int j = 0; j < dp[i].length; j++) {
//					System.out.print("(" + i + ", " + j + ") = " + dp[i][j] + "    ");
//				}
//				System.out.println();
//			}
		}
	}
	
	// c == 이번 열
	// status == 0 이전 열(c - 1)에서 아무것도 떼지 않음, 1: 윗쪽, 2: 아랫쪽
	private static int calcSticker(int c, int status) {
		if (c == N) return 0; // Base case
		if (dp[c][status] != -1) return dp[c][status]; // 이미 계산된 값 return
		
		int temp = 0;
		int result = calcSticker(c + 1, 0); // 이번 행에서 아무것도 떼지 않는 것을 기본값으로
		temp = result;
		
		if (status != 1) {
			int a = calcSticker(c + 1, 1) + values[0][c]; // 다음 열의 윗쪽 스티커 + 현재 행, 현재 열 (0, c)를 더한 값
			if (a > result) {
				System.out.println("Added " + calcSticker(c + 1, 1) + ", " + values[0][c]);
				//System.out.println("status is not 1, in " + c + ", " + a + " is bigger than " + result);
				result = a;
			}
		}
		
		if (status != 2) {
			int a = calcSticker(c + 1, 2) + values[1][c]; // 다음 열의 아랫쪽 스티커 + 현재 행, 현재 열 (1, c)를 더한 값
			if (a > result) {
				System.out.println("Added " + calcSticker(c + 1, 2) + ", " + values[1][c]);
				result = a;
			}
		}
		
		if (temp == result) {
			System.out.println("result not changed " + result);
		}
		
		// 위 세 값을 비교해서 result를 갱신해서 return
		
		dp[c][status] = result;
		System.out.println("c is " + c + ", status is " + status + " " + dp[c][status]);
		System.out.println("====");
		return result;
	}
}
