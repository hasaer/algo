import java.util.*;

public class DFSOrigin {
	
	private int V; // ����
	private LinkedList<Integer> adj[];
	
	DFSOrigin(int v) {
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList();
		}
	}
	
	void addEdge(int v, int w) {
		adj[v].add(w); // �ܹ��� only
		//adj[w].add(v); // ��������
	}
	
	void DFSUtil(int v, boolean visited[]) {
		visited[v] = true;
		System.out.print(v + " ");
		
		// �湮�� ���(adj[v])�� ������ ��� ��带 ������
		Iterator<Integer> i = adj[v].listIterator();
		
		while(i.hasNext()) {
			int n = i.next();
			// �湮���� ���� ����� DFSUtil�� n ������ ���ȣ��
			if (!visited[n])
				DFSUtil(n, visited);
		}
	}
	
	// ���� ���
	void DFS(int v) {
		boolean[] visited = new boolean[V]; // �湮 ���� false�� �ʱ�ȭ
		
		DFSUtil(v, visited); // ���� ��ȯ ����
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

	    g.DFS(2); /* �־��� ��带 ���� ���� DFS Ž�� */
	}
}
