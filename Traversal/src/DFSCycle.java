import java.util.*;

public class DFSCycle {
	
	static int[] adj;
	static int start;
	static boolean[] visited;
	static int count;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			
			int N = sc.nextInt();
			
			visited = new boolean[N];
			adj = new int[N];
			
			for (int j = 0; j < N; j++) {
				int V = sc.nextInt();
				adj[j] = V;
			}
			
			count = 0;
			for (int k = 0; k < adj.length; k++) {
				if (!visited[k]) {
					DFS(k);
				}
			}
			System.out.println(count);
		}
	}
	
	static void DFS(int v) {
		if (visited[v]) {
			count++;
			return;
		}
		visited[v] = true;
		DFS(adj[v] - 1);
	}
}
