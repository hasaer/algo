import java.util.*;
import java.io.*;

public class BFS2667 {

	static int N;
	static int[][] input;
	static boolean[][] visited;
	static PriorityQueue<Integer> pq; // count ����
	
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
					bfs(i, j); // ��������� ȣ����� �ʱ� ������, bfs �ȿ��� while�� �� ������ count���� �� ���� �� ����
					// �� �� bfs ���� �ش� ���� �� ã�Ƴ� �� �ֱ� ������ �ۿ��� count ���� �ʰ� �ȿ��� ����
				}
			}
		}

		System.out.println(pq.size());

		while (!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
	}

	static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<int[]>(); // 1-1. ���ο� ť-��ũ�帮��Ʈ<int[]>
		queue.offer(new int[] { x, y }); // 1-2. Queue�� ������ ��ǥ �迭 ����
		
		int count = 0; // 1-3. �̹� bfs ī��Ʈ �ʱ�ȭ
		
		while (!queue.isEmpty()) { // queue�� �� ������
			int curX = queue.peek()[0];
			int curY = queue.peek()[1];
			queue.poll(); // �̹� ��ǥ �����ϰ� �˻� ����
			
			// 2-1. �ش� ��ǥ ���Ἲ �˻�
			if (curX < 0 || curY < 0 || curX >= N || curY >= N) continue;
			
			// 2-2. ���� 0�� ��쿡�� �н�			
			if (input[curX][curY] == 0) continue;
			
			// 2-3. �̹� �湮�� ���� ��쿡�� �н�
			if (visited[curX][curY]) continue;
			
			// 3. �̰��� ������ �����̴�.
			count++;
			visited[curX][curY] = true;
			
			// 4. ���� ���� ��ǥ�� ť�� �ְ� �ǵ��ϵ���
			for (int i = 0; i < 4; i++) {
				queue.add(new int[] { curX + dx[i], curY + dy[i] });
			}
		}
		
		pq.offer(count); // 5. �� ������ count�� answers �켱���� ť�� �־���
	}

}
