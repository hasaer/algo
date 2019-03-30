import java.util.Scanner;

public class DFS1743 {

	static int N, M, count, answer;
	
	static int[][] floor;
	static boolean[][] visited;
	
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		int K = sc.nextInt();
		
		floor = new int[N][M];
		visited = new boolean[N][M];
		
		for (int i = 0; i < K; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			floor[r - 1][c - 1] = 1;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j] && floor[i][j] == 1) {
					count = 0;
					dfs(i, j);
					if (count > answer) {
						answer = count;
					}
				}
			}
		}
		
		System.out.println(answer);
	}

	static void dfs(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i]; int ny = y + dy[i];
			if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
				if (!visited[nx][ny] && floor[nx][ny] == 1) {
					visited[nx][ny] = true;
					count++;
					dfs(nx, ny);
				}
			}
		}
	}
}
