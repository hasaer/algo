import java.util.*;
import java.io.*;

public class BFS2667 {

	static int N;
	static int[][] input;
	static boolean[][] visited;
	static PriorityQueue<Integer> pq; // count 담기용
	
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		input = new int[N][N];
		visited = new boolean[N][N];
		pq = new PriorityQueue<Integer>();

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			String[] words = line.split("");
			for (int j = 0; j < N; j++) {
				input[i][j] = Integer.parseInt(words[j]);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j] && input[i][j] == 1) {
					bfs(i, j); // 재귀적으로 호출되지 않기 때문에, bfs 안에서 while문 다 돌리고 count까지 답 구할 수 있음
					// 한 번 bfs 들어가면 해당 단지 다 찾아낼 수 있기 때문에 밖에서 count 세지 않고 안에서 센다
				}
			}
		}

		System.out.println(pq.size());

		while (!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
	}

	static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<int[]>(); // 1-1. 새로운 큐-링크드리스트<int[]>
		queue.offer(new int[] { x, y }); // 1-2. Queue에 시작점 좌표 배열 넣음
		
		int count = 0; // 1-3. 이번 bfs 카운트 초기화
		
		while (!queue.isEmpty()) { // queue가 빌 때까지
			int curX = queue.peek()[0];
			int curY = queue.peek()[1];
			queue.poll(); // 이번 좌표 추출하고 검사 시작
			
			// 2-1. 해당 좌표 무결성 검사
			if (curX < 0 || curY < 0 || curX >= N || curY >= N) continue;
			
			// 2-2. 값이 0일 경우에도 패스			
			if (input[curX][curY] == 0) continue;
			
			// 2-3. 이미 방문한 곳일 경우에도 패스
			if (visited[curX][curY]) continue;
			
			// 3. 이것은 인접한 단지이다.
			count++;
			visited[curX][curY] = true;
			
			// 4. 다음 인접 좌표를 큐에 넣고 판독하도록
			for (int i = 0; i < 4; i++) {
				queue.add(new int[] { curX + dx[i], curY + dy[i] });
			}
		}
		
		pq.offer(count); // 5. 다 돌고나면 count를 answers 우선순위 큐에 넣어줌
	}

}
