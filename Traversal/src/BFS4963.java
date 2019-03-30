import java.io.*;
import java.util.*;

public class BFS4963 {

	static int W, H;

	static int[][] field;
	static boolean[][] visited;

	static int count;

	static int[] dx = { 1, -1, 0, 0, 1, -1, 1, -1 };
	static int[] dy = { 0, 0, 1, -1, -1, 1, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true) {
			// StringTokenizer가 split보다 빠름
			st = new StringTokenizer(br.readLine());

			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			if (W == 0 && H == 0) break;

			field = new int[H][W];
			visited = new boolean[H][W];
			count = 0;

			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					field[i][j] = Integer.parseInt(st.nextToken()); 
				}
			}

			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (!visited[i][j] && field[i][j] == 1) {
						count++;
						bfs(i, j);
					}
				}
			}

			System.out.println(count);
		}
		
		br.close();
	}

	static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] { x, y });

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int curX = cur[0]; int curY = cur[1];

			// 2-1. 해당 좌표 무결성 검사
			if (curX < 0 || curY < 0 || curX >= H || curY >= W) continue;

			// 2-2. 값이 0일 경우에도 패스			
			if (field[curX][curY] == 0) continue;

			// 2-3. 이미 방문한 곳일 경우에도 패스
			if (visited[curX][curY]) continue;

			//count++;
			visited[curX][curY] = true;

			for (int i = 0; i < 8; i++) {
				queue.offer(new int[] { curX + dx[i], curY + dy[i] });
			}
		}
	}

}
