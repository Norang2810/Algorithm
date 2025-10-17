import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//Prim 알고리즘 -> 정점 중심
//Kruskal 알고리즘 -> 간선 중심

//둘중 프림 알고리즘 사용!!
public class Main {

	static class Node {
		int vertex;
		int weight;

		public Node(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		List<Node>[] graph = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			graph[a].add(new Node(b, w));
			graph[b].add(new Node(a, w));
		}

		boolean[] visited = new boolean[V + 1];
		PriorityQueue<Node> pq = new PriorityQueue<Node>((a, b) -> a.weight - b.weight);

		pq.add(new Node(1, 0)); // 시작 노드
		int result = 0;
		int count = 0;

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			if (visited[cur.vertex])
				continue;
			else {
				visited[cur.vertex] = true;
				result += cur.weight;
				count++;
			}
			
			if(count == V) break; //모든 정점 연결 완료시 종료
			
			for(Node next : graph[cur.vertex]) {
				if(!visited[next.vertex]) {
					pq.add(next);
				}
			}
			
			
		}
		System.out.println(result);
	}

}
