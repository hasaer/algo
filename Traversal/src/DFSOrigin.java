import java.util.*;

public class DFSOrigin {
	
	private int V; // 개수
	private LinkedList<Integer> adj[];
	
	DFSOrigin(int v) {
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList();
		}
	}
	
	void addEdge(int v, int w) {
		adj[v].add(w); // 단방향 only
		//adj[w].add(v); // 양방향까지
	}
	
	void DFSUtil(int v, boolean visited[]) {
		visited[v] = true;
		System.out.print(v + " ");
		
		// 방문한 노드(adj[v])와 인접한 모든 노드를 가져옴
		Iterator<Integer> i = adj[v].listIterator();
		
		while(i.hasNext()) {
			int n = i.next();
			// 방문하지 않은 노드라면 DFSUtil에 n 던져서 재귀호출
			if (!visited[n])
				DFSUtil(n, visited);
		}
	}
	
	// 시작 노드
	void DFS(int v) {
		boolean[] visited = new boolean[V]; // 방문 여부 false로 초기화
		
		DFSUtil(v, visited); // 최초 순환 시작
	}
	
	public static void main(String[] args) {
		DFSOrigin g = new DFSOrigin(4);

	    g.addEdge(0, 1);
	    g.addEdge(0, 2);
	    g.addEdge(1, 2);
	    g.addEdge(2, 0);
	    g.addEdge(2, 3);
	    g.addEdge(3, 3);
	    
	    for (int i = 0; i < g.adj.length; i++) {
	    	System.out.println(g.adj[i].size());
	    	Collections.sort(g.adj[i]);
	    }

	    g.DFS(2); /* 주어진 노드를 시작 노드로 DFS 탐색 */
	}
}
