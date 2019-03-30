import java.util.*;
import java.io.*;

public class BFS2178 {

	static int N, M;
	static int[][] field, distance;
	static boolean[][] visited;
	
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		field = new int[N + 1][M + 1];
		distance = new int[N + 1][M + 1];
		visited = new boolean[N + 1][M + 1];
		
		for (int i = 1; i < N + 1; i++) {
			String line = br.readLine();
			String[] words = line.split("");
			for (int j = 1; j < M + 1; j++) {
				field[i][j] = Integer.parseInt(words[j - 1]);
			}
		}
		
		bfs();
		
		br.close();
		
		// 1, 1에서 N, M까지이기 때문에 전부 다 탐사하는 게 목적이 아님
		// 최초 좌표에서 붙어있는 것들 좌표만 따라가면서 각 좌표의 distance를 구해주면 됨
//		for (int i = 1; i < N + 1; i++) {
//			for (int j = 1; j < M + 1; j++) {
//				System.out.print(field[i][j] + " ");
//			}
//			System.out.println();
//		}
	}
	
	static void bfs() {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] { 1, 1 });
		visited[1][1] = true;
		distance[1][1] = 1;
		
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int curX = cur[0]; int curY = cur[1];
			
			for (int i = 0; i < 4; i++) {
				int nx = curX + dx[i]; int ny = curY + dy[i];
				if (nx >= 0 && ny >= 0 && nx < N + 1 && ny < M + 1) {
					if (field[nx][ny] == 1) {
						if (!visited[nx][ny]) {
							distance[nx][ny] = distance[curX][curY] + 1;
							queue.offer(new int[] { nx, ny } );
							visited[nx][ny] = true;	
						}	
					}
				}
			}
		}
		
		System.out.println(distance[N][M]);
	}

}
