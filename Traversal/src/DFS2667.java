import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class DFS2667 {

	static int N, count, answer;
	
	static int[][] floor;
	static boolean[][] visited;
	static ArrayList<Integer> answers = new ArrayList<Integer>();
	
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		floor = new int[N][N];
		visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			String[] words = line.split("");
			for (int j = 0; j < words.length; j++) {
				floor[i][j] = Integer.parseInt(words[j]);
			}
		}
		

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j] && floor[i][j] == 1) {
					count = 1;
					dfs(i, j);
					answers.add(count);
				}
			}
		}
		
		System.out.println(answers.size());
		Collections.sort(answers);
		Iterator it = answers.listIterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
	static void dfs(int x, int y) {
		visited[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i]; int ny = y + dy[i];
			if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
				if (!visited[nx][ny] && floor[nx][ny] == 1) {
					//visited[nx][ny] = true;
					count++;
					dfs(nx, ny);
				}
			}
		}
	}

}
