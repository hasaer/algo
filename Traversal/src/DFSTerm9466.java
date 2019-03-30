import java.util.Scanner;

public class DFSTerm9466 {

	static int count;
	static int[] target;
	static boolean[] visited, finished;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int i = 0; i < T; i++) {
			int n = sc.nextInt();
			
			count = 0;
			target = new int[n + 1];
			visited = new boolean[n + 1];
			finished = new boolean[n + 1];
			
			for (int j = 1; j <= n; j++) {
				target[j] = sc.nextInt();
			}			
			System.out.println();
			
			for (int j = 1; j <= n; j++) {
				dfs(j);
			}
			
			System.out.println(n - count);
		}
	}

	static void dfs(int n) {
		if (visited[n]) return;
		
		visited[n] = true;
		
		int next = target[n];
		
		System.out.println("New DFS from " + n + " to " + next);
		
		if (!visited[next]) {
			dfs(next);
		} else {
			if (!finished[next]) {
				count++;
				for (int i = next; i != n; i = target[i]) {
					System.out.println("next´Â  " + i + " nÀº " + n + " target[i]´Â " + i);
					count++;
				}
			}
		}
		System.out.println(n + " DFS Finished ***");
		finished[n] = true;
	}
}
