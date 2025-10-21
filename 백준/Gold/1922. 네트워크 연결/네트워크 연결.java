import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


//Prim 풀이
public class Main {

	static StringTokenizer st;

	static class Node {
		int Vertex;
		int Weight;

		public Node(int Vertex, int Weight) {
			this.Vertex = Vertex;
			this.Weight = Weight;
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		List<Node>[] graph = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			graph[a].add(new Node(b, w));
			graph[b].add(new Node(a, w));

		}

		boolean[] visited = new boolean[N + 1];

		PriorityQueue<Node> pq = new PriorityQueue<Node>((a, b) -> a.Weight - b.Weight);

		pq.offer(new Node(1, 0));

		int totalCost = 0; // 전체 비용
		int connected = 0; // 연결된 정점 수

		while (!pq.isEmpty() && connected < N) {

			Node cur = pq.poll();

			if (visited[cur.Vertex]) { 
				continue;
			} else {
				visited[cur.Vertex] = true;
				totalCost += cur.Weight;
				connected++;
			}

			for (Node next : graph[cur.Vertex]) {
				if (!visited[next.Vertex]) {
					pq.offer(next);
				}
			}

		}
		System.out.println(totalCost);
	}

}
