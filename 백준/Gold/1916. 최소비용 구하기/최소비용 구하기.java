import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int city;
		int cost;

		public Node(int city, int cost) {
			this.city = city;
			this.cost = cost;
		}
	}

	static List<Node>[] graph;
	static int[] dist;
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		

		int N = Integer.parseInt(br.readLine()); // 도시 개수
		int M = Integer.parseInt(br.readLine()); // 버스 개수

		graph = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<Node>();
		}

		dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			graph[start].add(new Node(end, cost));
		}

		st = new StringTokenizer(br.readLine());
		int startCity = Integer.parseInt(st.nextToken());
		int endCity = Integer.parseInt(st.nextToken());

		dijkstra(startCity);

		System.out.println(dist[endCity]);
	}

	static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>((a, b) -> a.cost - b.cost);

		pq.offer(new Node(start, 0));
		dist[start] = 0;

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			if (dist[cur.city] < cur.cost) {
				continue;
			}

			for (Node next : graph[cur.city]) {
				int newCost = cur.cost + next.cost;

				if (newCost < dist[next.city]) {
					dist[next.city] = newCost;
					pq.offer(new Node(next.city, newCost));
				}
			}

		}
	}
}
